# Введение {#intro}

В своей работе я сталкивался со различными сложностями:

* Борьба с фреймворком.
  Авторы ферймворков создают их для решения собственных проблем, а не ваших.
  Авторы фреймворка могут изменять его, а вы нет.
  Вы вынуждены продолжать использовать фреймворк, когда он перестал подходить.

* Частые изменения требований.
  Бизнес, который обслуживается вашим приложением постоянно изменяется.
  По другому быть не может. Таков мир.

* Раннее принятие решений.
  Еще не разобравшисть в предметной области проекта мы должны принимать решения.
  Какая база данных? Какая схема таблиц?
  Какой фреймворк?
  Веб приложение? Мобильное приложение?

* Работа в команде.
  Распределение ролей.
  Затраты на синхронизацию.
  Конфликты в системе контроля версий.

Все это относится к проектам которые:
+ длятся от полугода
+ на старте не имеют четких требований

Есть несколько книг, которые поднимают эти вопросы, а так же множество других:

* Архитектура корпоративных программных приложений. Мартин Фаулер.
* Принципы, паттерны и методики гибкой разработки на языке C\#. Роберт Мартин.
* Clean Architecture. Роберт Мартин.
* Проблемно-ориентированное проектирование\(DDD\). Эрик Эванс.

Описанное в этих книгах резко контрастирует с моим опытом.
Редко кто может похвастаться тем,
что его команде доставляет удовольствие работа с проектом даже спустя годы после старта.

У подобных книг есть общая проблема. Они дают теоритическую базу, но чтобы применить ее на практике
нужно изрядно потрудиться. Фактически, этот материал - способ систематизировать мои знания.

Мы сделаем простой проект публикации текстов. Начнем с нуля и поверхностно познакомимся с:

+ Domain Driven Design (DDD)
+ принципами SOLID
+ Clean architecture
+ паттерном Data Mapper
+ паттерном Unit of Work
+ паттерном Identity Map
+ Clojure

У меня нет цели пересказывать других авторов.
Я буду кратко объяснять идеи через призму потребностей нашего проекта и буду давать много
ссылок на первоисточники.

В качестве языка для проекта я выбрал [Clojure](https://clojure.org/about/rationale).
В него заложены крутые идеи, без которых я бы не смог реализовать задуманное.
Вы можете ознакомиться с презентацией автора языка, чтобы сформировать первое впечатление:
[Effective Programs, 10 Years of Clojure](https://github.com/matthiasn/talk-transcripts/blob/master/Hickey_Rich/EffectivePrograms.md).