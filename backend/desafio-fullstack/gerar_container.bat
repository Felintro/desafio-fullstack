@echo off

echo Executando remove.bat
call remove.bat

echo.
echo Executando build_image.bat
call build_image.bat

echo.
echo Executando run_container.bat
call run_container.bat

echo.
echo Todos os scripts foram executados.
pause