@echo off
echo Eliminando atributos uuid de archivos .jrxml...
powershell -Command "$reportsPath = 'src\main\resources\reports'; $files = Get-ChildItem -Path $reportsPath -Filter '*.jrxml'; foreach ($file in $files) { $content = Get-Content $file.FullName -Raw -Encoding UTF8; $originalContent = $content; $content = $content -replace '(<jasperReport[^>]*)\s+uuid=\"[^\"]*\"([^>]*>)', '$1$2'; if ($content -ne $originalContent) { Set-Content $file.FullName $content -Encoding UTF8 -NoNewline; Write-Host 'Eliminado uuid de:' $file.Name -ForegroundColor Green } else { Write-Host 'OK:' $file.Name -ForegroundColor Yellow } }"
echo.
echo Proceso completado!
pause

