# Script para eliminar atributos uuid de los archivos .jrxml
# Ejecutar después de editar archivos en Jaspersoft Studio

$reportsPath = "src\main\resources\reports"
$files = Get-ChildItem -Path $reportsPath -Filter "*.jrxml"

foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw -Encoding UTF8
    $originalContent = $content
    
    # Eliminar uuid de la etiqueta jasperReport
    $content = $content -replace '(<jasperReport[^>]*)\s+uuid="[^"]*"([^>]*>)', '$1$2'
    
    if ($content -ne $originalContent) {
        Set-Content $file.FullName $content -Encoding UTF8 -NoNewline
        Write-Host "Eliminado uuid de: $($file.Name)" -ForegroundColor Green
    } else {
        Write-Host "No se encontró uuid en: $($file.Name)" -ForegroundColor Yellow
    }
}

Write-Host "`nProceso completado!" -ForegroundColor Cyan

