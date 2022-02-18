
![](https://img.shields.io/badge/-Kotlin-%23f68807?style=flat&logo=Kotlin)
![](https://img.shields.io/badge/-Android-%230096d6?style=flat&logo=Android)
![](https://img.shields.io/badge/-Retrofit2-%2346ba84?style=flat&logo=square)
![](https://img.shields.io/badge/-Room-%20%23fbbd01?style=flat&logo=semanticweb)
![](https://img.shields.io/badge/-MVVM-lightgrey?style=flat&logo=Openlayers)
![](https://img.shields.io/badge/-RecyclerView-9cf?style=flat&logo=KashFlow)
![](https://img.shields.io/badge/-LiveData-brightgreen?style=flat&logo=ICQ)
![](https://img.shields.io/badge/-Bundle-orange?style=flat&logo=letsencrypt)
![](https://img.shields.io/badge/-ViewModel-red?style=flat&logo=Leaflet)
![](https://img.shields.io/badge/-Picasso-ff69b4?style=flat&logo=Elixir)
![](https://img.shields.io/badge/-NavGraph-blueviolet?style=flat&logo=Caffeine)

# News
📰 A news app for Android that works with the ["Inshorts News API"](https://github.com/cyberboysumanjay/Inshorts-News-API)

# Новости
📰 Новостное android-приложение, которое работает с ["Inshorts News API"](https://github.com/cyberboysumanjay/Inshorts-News-API)

Приложение состоит из трёх фрагментов: стартовый, со списком новостей и с детализацией отдельной новости.

  ## 1. Стартовый фрагмент
  
  ![Стартовый фрагмент](https://github.com/FezzMad/News/blob/master/fragment_start.jpg)
  
  В этом фрагменте происходит загрузка данных с помощью ***ViewModel*** с API с использованием библиотеки ***Retrofit2***, если есть интернет-соединение, или с локальной базы данных ***Room***, если подключения к интернету нет.
  После успешного получения данных список новостей помещается в ***Bundle*** и передаётся с помощью ***NavGraph*** во фрагмент со списком новостей. Благодаря ***LiveData*** происходит автоматический переход к новостному фрагменту.
  
  ## 2. Фрагмент со списком новостей
  
   ![Стартовый фрагмент](https://github.com/FezzMad/News/blob/master/fragment_news.jpg)
   
   Новостной экран принимает Bundle от стартового фрагмента со списокм внутри и выводит данные в ***RecyclerView*** через ***Adapter***. Подгрузка изображения реализована с помощью библиотеки ***Picasso***.
   Информацию можно обновить в этом же фрагменте с помощью Pull To Refresh, реализованного с помощью ***SwipeRefreshLayout***. То есть достаточно "упереться" в начало списка и потянуть вниз.
   Если интернет-соединение отсутствует, то при обновлении приложение выведет короткий ***Toast*** с текстом "Check your internet connection". 
   По нажатию карточки с новостью вся информация по выбранному элементу также, как и в стартовом фрагменте, помещается в Bundle и передаётся с помощью NavGraph во фрагмент отдельной новости. 
   Вместе с этим происходит переход на последний фрагмент. 
  
  ## 3. Фрагмент с детализацией отдельной новости 
  
   ![Стартовый фрагмент](https://github.com/FezzMad/News/blob/master/fragment_detail.jpg)
   
   Фрагмент с детализацией новости принимает Bundle, содержащий всю информацию по ней, от фрагмента со списоком и выводит данные пользователю. При переходе назад с помощью жеста или навигационной кнопки, приложение возвращает пользователя к списку новостей. Вернуться на стартовый фрагмент нельзя.
   
   
   
   
