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

<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 100 100"><title>Allure_Report</title><image width="185" height="164" transform="translate(12.1 13.7) scale(0.44)" xlink:href="data:image/png;base64,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"/></svg>
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

Параметры для запуска сборки в jenkins:
:one: URL - (выбор url)

:two: BROWSER - (выбор браузера)

:three: BROWSERSIZE - (выбор размера окна браузера)

:four: VERSION - (выбор версии браузера)

:five: REMOTE_DRIVER_URL - (выбор удалённого драйвера)

:seven: ALLURE_NOTIFICATIONS_VERSION - (выбор версии allure)

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/IBS_test/allure/">Allure report</a>

## ⛅: Overview
<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/overview.png">
</p>

## 🧪: Suites
<p align="center">
<img title="Allure Tests" src="images/screens/suites.png">
</p>

## 💹: Graphs
<p align="center">
<img title="Allure Tests" src="images/screens/graphs.png">
</p>

## <img src="images/logo/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Интеграция уведомлений в telegram

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/telegram.png" >
</p>

## <img src="images/logo/Selenoid.svg" width="25" height="25" alt="Jenkins"/></a> Видео <a target="_blank" href="https://selenoid.autotests.cloud/video/fe43b9f89a795109ff4959044e6650d7.mp4"> прохождения тестов </a>
<p align="center">
<a href="https://selenoid.autotests.cloud/video/fe43b9f89a795109ff4959044e6650d7.mp4"></a>
</p>