# Проект по автоматизации 34play


## 🚀: Содержание:

- [Технологии и инструменты](#earth_africa-технологии-и-инструменты)
- [Реализованные проверки](#earth_africa-Реализованные-проверки)
- [Сборка в Jenkins](#earth_africa-Jenkins-job)
- [Запуск из терминала](#earth_africa-Запуск-тестов-из-терминала)
- [Примеры использования](#earth_africa-Allure-отчет)
- [Allure отчет](#earth_africa-Allure-отчет)
- [Отчет в Telegram](#earth_africa-Уведомление-в-Telegram-при-помощи-бота)
- [Видео примеры прохождения тестов](#earth_africa-Примеры-видео-о-прохождении-тестов)



## 🧰: Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## ⚓: Реализованные проверки

Набор тест-кейсов функционала авторизации, функционала работы с товарами, добавления их в корзину, а так-же 
проверки основных навигационных элементов страницы. Примеры автоматизированных кейсов:

Тест 1
- ✓ Переход на сайт 34play
- ✓ Нажатие на кнопку "Подтвердить что мне 18"
- ✓ Нажатие на кнопку "Подтверждение региона"
- ✓ Нажатие на кнопку "Вход"
- ✓ Ввод существующего логина
- ✓ Ввод валидного пароля для логина
- ✓ Проверка валидации введенных данных


- Тест 2
- ✓ Переход на сайт 34play
- ✓ Нажатие на кнопку "Подтвердить что мне 18"
- ✓ Нажатие на кнопку "Подтверждение региона"
- ✓ Нажатие на изображение, карточка товара категории толстовки
- ✓ Выбор первого в списке экземпляра толстовки
- ✓ В модальном окне выбор размер товара
- ✓ В модальном окне нажатие кнопки добавления товара в корзину
- ✓ Переход в раздел Корзина
- ✓ Проверка добавленного товара на наличие и соответствие признаков

## 🧙: Параметры сборки в Jenkins:

:yum: Browser (браузер, по умолчанию chrome)

:zany_face: Version (версия браузера, по умолчанию 100.0)

:smirk: Browser_size (размер окна браузера, по умолчанию 3280x2840)

:relieved: URL (выбор url для теста)

:woozy_face: REMOTE_DRIVER_URL (адрес удалённого драйвера)

:cowboy_hat_face: THREADS (выбор количества потоков для запуска)


## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/IBS_test/"> job </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/08-alexlis-web/"><img src="images/screens/jenkins.png" alt="Jenkins"/></a>
</p>



## 🏗️: Запуск тестов из терминала
Локальный запуск:
```
gradle clean test
```

Удаленный запуск:
```
clean
test
-Dbrowser=${BROWSER}
-Dversion=${VERSION}
-Dsize=${BROWSER_SIZE}
-Durl=${REMOTE_URL}
```

# Примеры использования

### Для запуска удаленных тестов необходимо заполнить remote.properties или передать значение:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Команда для запуска всех тестов:
```bash
gradle clean alltests test
```

Запускайте тесты с незаполненным remote.properties:
```bash
gradle clean simple_test test
```

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/IBS_test/allure/">Allure report</a>

## ⛅: Основной отчет
<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/overview.png">
</p>
C:\Users\maver\IBS-tests\images\screens\report.PNG

## 🧪: Тесты
<p align="center">
<img title="Allure Tests" src="images/screens/suites.png">
</p>

## 💹: Графики
<p align="center">
<img title="Allure Tests" src="images/screens/graphs.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram при помощи бота

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/telegram.png" >
</p>

## <img src="images/logo/Selenoid.svg" width="25" height="25" alt="Jenkins"/></a> Видео <a target="_blank" href="https://selenoid.autotests.cloud/video/fe43b9f89a795109ff4959044e6650d7.mp4"> прохождения тестов </a>
<p align="center">
<a href="https://selenoid.autotests.cloud/video/fe43b9f89a795109ff4959044e6650d7.mp4"></a>
</p>