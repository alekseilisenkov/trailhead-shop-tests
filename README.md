# Проект по автоматизации сайта  [34play](https://www.34play.me/)
**Официальный интернет магазин 34 PLAY**
&nbsp;
![Официальный интернет магазин 34 PLAY](images/screens/mainshop.png)
&nbsp;


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

## 🚀: Реализованные проверки

Набор тест-кейсов функционала авторизации, функционала работы с товарами, добавления их в корзину, а так-же 
проверки основных навигационных элементов страницы. Примеры автоматизированных кейсов:

Тест 1

- ✓ _Переход на сайт 34play_
- ✓ _Нажатие на кнопку "Подтвердить что мне 18"_
- ✓ _Нажатие на кнопку "Подтверждение региона"_
- ✓ _Нажатие на кнопку "Вход"_
- ✓ _Ввод существующего логина_
- ✓ _Ввод валидного пароля для логина_
- ✓ _Проверка валидации введенных данных_




- Тест 2
- ✓ _Переход на сайт 34play_
- ✓ _Нажатие на кнопку "Подтвердить что мне 18"_
- ✓ _Нажатие на кнопку "Подтверждение региона"_
- ✓ _Нажатие на изображение, карточка товара категории толстовки_
- ✓ _Выбор первого в списке экземпляра толстовки_
- ✓ _В модальном окне выбор размер товара_
- ✓ _В модальном окне нажатие кнопки добавления товара в корзину_
- ✓ _Переход в раздел Корзина_
- ✓ _Проверка добавленного товара на наличие и соответствие признаков_




## <img src="images/logo/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/08-alexlis-web/"> job </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/08-alexlis-web/"><img src="images/screens/jenkins.png" alt="Jenkins"/></a>
</p>


### 🧙: Параметры сборки в Jenkins:

:yum: Browser (браузер, по умолчанию chrome)

:zany_face: Version (версия браузера, по умолчанию 100.0)

:smirk: Browser_size (размер окна браузера, по умолчанию 3280x2840)

:relieved: URL (выбор url для теста)

:woozy_face: REMOTE_DRIVER_URL (адрес удалённого драйвера)

:cowboy_hat_face: THREADS (выбор количества потоков для запуска)

## 🏗️: Для запуска тестов из терминала необходимо заполнить remote.properties или передать значение:

:one: URL - (выбор url)

:two: BROWSER - (выбор браузера)

:three: BROWSERSIZE - (выбор размера окна браузера)

:four: VERSION - (выбор версии браузера)

:five: REMOTE_DRIVER_URL - (выбор удалённого драйвера)

:seven: ALLURE_NOTIFICATIONS_VERSION - (выбор версии allure)

## <img src="images/logo/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/08-alexlis-web/14/allure/#">Allure report</a>

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