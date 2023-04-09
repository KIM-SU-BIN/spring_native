set COMPANY_NAME1=sensemeka
set PROJECT_NAME1=tweaksense
set PROJECT_NAME2=TweakSense
ren src\main\java\com\sensemeka  %COMPANY_NAME1%
ren src\main\java\com\%COMPANY_NAME1%\tweaksense %PROJECT_NAME1%
ren src\main\java\com\%COMPANY_NAME1%\%PROJECT_NAME1%\TweakSenseApplication.java %PROJECT_NAME2%Application.java
ren src\test\java\com\sensemeka  %COMPANY_NAME1%
ren src\test\java\com\%COMPANY_NAME1%\tweaksense %PROJECT_NAME1%
ren src\test\java\com\%COMPANY_NAME1%\%PROJECT_NAME1%\TweakSenseApplicationTests.java %PROJECT_NAME2%ApplicationTests.java

