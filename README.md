# запуск бота на сервере

1. Яндекс-клауд + платный акаунт
2. Все сервисы - *computer cloud* + *создать вирт машину*
3. имя и описание (зона дост ru-ctсек. 1-а)
4. выбор Ubuntu 20.4 b настройки по цене
5. логин - andrey
6. генерируем ssh ( в АБ/.ssh) скач PuttyGen, водим курсором при установки
7. Создать VM и ждем статус RUNNING
8. Идем в идею (файл-проект структуры-артифакты- "+" - jar - From modules whith depend... - main - в конце строки удаляем *src* ) только папка с нашей прогой
9. в появ окне APPLY OK
10. в идеи папка META-INF
11. Правее  FILE    - BUILD -BUILD Artifackts-Build
12. в п.10 - папка OUT- в ней файл нашеНазвание.jar -копируем (CopyPasth-Absolut P.....)
13. идем в сервер п.7 - сетевой интерфейс - публич iPv4 = копируем 
14. W+R - сmd = консоль (*ssh andrey@вставл-п.13*) - yes (если ошибка - пробуем *ssh-keygen*) = много текста ..... переход **на папку andrey@javafree14**
15. теперь мы в консоли Linux - ls = gfgrfпдолж быть пустой
16. открыв W+R - сmd = консоль *scp вставляем п. 12 пробел *andrey@вставл-п.13* и в конце ":"   - должно выдать webinar.......Telegram.jar
17. опять в 1 консоль и ls  = должно наш файл
18. пишем java --version - копир версию наприм 11
19. sudo - (от имени администратора обяз в Linux)
    > sudo и версия джавы = установка 
    > (сайт)[https://computingforgeeks.com/how-to-run-java-jar-application-with-systemd-on-linux/]
    >> меняем: в редакторе (лучше nano) сервис-вокингдиректори/home/andrey
    >> ......- jar Javafree14.jar
    все сохраняем
20. sudo chown -R ........... меняем на /home/andrey
    