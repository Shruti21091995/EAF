# Maven Installation Script for Windows
# This script downloads and installs Apache Maven

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Maven Installation Script" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Check if Java is installed
Write-Host "Checking Java installation..." -ForegroundColor Yellow
try {
    $javaVersion = java -version 2>&1
    Write-Host "✓ Java is installed: $($javaVersion[0])" -ForegroundColor Green
} catch {
    Write-Host "✗ Java is not installed. Please install Java first!" -ForegroundColor Red
    exit 1
}

# Maven version to install
$mavenVersion = "3.9.6"
$mavenUrl = "https://dlcdn.apache.org/maven/maven-3/$mavenVersion/binaries/apache-maven-$mavenVersion-bin.zip"
$downloadPath = "$env:TEMP\apache-maven-$mavenVersion-bin.zip"
$installPath = "C:\Program Files\Apache\Maven"

Write-Host ""
Write-Host "Downloading Maven $mavenVersion..." -ForegroundColor Yellow
Write-Host "URL: $mavenUrl" -ForegroundColor Gray

try {
    # Download Maven
    Invoke-WebRequest -Uri $mavenUrl -OutFile $downloadPath -UseBasicParsing
    Write-Host "✓ Download completed!" -ForegroundColor Green
} catch {
    Write-Host "✗ Download failed: $_" -ForegroundColor Red
    exit 1
}

Write-Host ""
Write-Host "Extracting Maven..." -ForegroundColor Yellow

try {
    # Create installation directory
    if (!(Test-Path $installPath)) {
        New-Item -ItemType Directory -Path $installPath -Force | Out-Null
    }
    
    # Extract Maven
    Expand-Archive -Path $downloadPath -DestinationPath $installPath -Force
    
    # Get the extracted folder name
    $extractedFolder = Get-ChildItem -Path $installPath -Directory | Where-Object { $_.Name -like "apache-maven-*" } | Select-Object -First 1
    $mavenHome = $extractedFolder.FullName
    
    Write-Host "✓ Maven extracted to: $mavenHome" -ForegroundColor Green
} catch {
    Write-Host "✗ Extraction failed: $_" -ForegroundColor Red
    exit 1
}

Write-Host ""
Write-Host "Setting up Environment Variables..." -ForegroundColor Yellow

try {
    # Set MAVEN_HOME
    [System.Environment]::SetEnvironmentVariable("MAVEN_HOME", $mavenHome, [System.EnvironmentVariableTarget]::Machine)
    Write-Host "✓ MAVEN_HOME set to: $mavenHome" -ForegroundColor Green
    
    # Add Maven bin to PATH
    $currentPath = [System.Environment]::GetEnvironmentVariable("Path", [System.EnvironmentVariableTarget]::Machine)
    $mavenBinPath = "$mavenHome\bin"
    
    if ($currentPath -notlike "*$mavenBinPath*") {
        $newPath = "$currentPath;$mavenBinPath"
        [System.Environment]::SetEnvironmentVariable("Path", $newPath, [System.EnvironmentVariableTarget]::Machine)
        Write-Host "✓ Maven bin added to PATH" -ForegroundColor Green
    } else {
        Write-Host "✓ Maven bin already in PATH" -ForegroundColor Green
    }
    
    # Update current session PATH
    $env:Path = [System.Environment]::GetEnvironmentVariable("Path", [System.EnvironmentVariableTarget]::Machine)
    
} catch {
    Write-Host "✗ Environment variable setup failed: $_" -ForegroundColor Red
    Write-Host "You may need to run this script as Administrator" -ForegroundColor Yellow
    exit 1
}

# Clean up
Write-Host ""
Write-Host "Cleaning up..." -ForegroundColor Yellow
Remove-Item $downloadPath -Force
Write-Host "✓ Temporary files removed" -ForegroundColor Green

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Maven Installation Completed!" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "IMPORTANT: Please close and reopen your terminal/PowerShell" -ForegroundColor Yellow
Write-Host "Then verify installation by running: mvn -version" -ForegroundColor Yellow
Write-Host ""
Write-Host "Maven Home: $mavenHome" -ForegroundColor Cyan
Write-Host "Maven Bin: $mavenBinPath" -ForegroundColor Cyan
Write-Host ""
