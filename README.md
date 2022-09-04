## Ecommerce concept


## Дизайн 

![image](https://user-images.githubusercontent.com/94394251/188326734-7cdeaabe-e59c-4831-a4ed-51e42009a171.png)
![image](https://user-images.githubusercontent.com/94394251/188326755-bfd3c15e-6b0c-43b4-a9a4-1758311446a0.png)
![image](https://user-images.githubusercontent.com/94394251/188326870-e2f16e33-c800-4178-86a6-962d11bf103f.png)


https://www.figma.com/file/KqZcU5m3GMxAHwgFkvCONz/ECOMMERCE


## Использованные технологии

- Clean Architecture, Multi-module architecture, MVVM
- Dependency Injection - Koin
- Adapter Delegate
- Google Map, Fused Location Provider Client
- Permissions
- Retrofit, OkHttp
- Room
- Кеширование данных (при первом входе данные берутся с сервера, далее с базы данных)
- Coroutines, Flow
- Deeplink для каждого экрана (mysite.com/home, mysite.com/details, mysite.com/cart)
- Firebase Push Notifications
- RecyclerView, ViewPager2
- LiveData
- Navigation Component
- Single Activity

## Описание

Тестовое задание по готовому дизайну на figma и функциональным заданием. 

Главный экран состоит из таких элементов, как выбор адреса и категорий товаров, viewpager с товарами Hot Sales, а также RecyclerView с товарами Best Seller. В связи со сложностью компоновки главного экрана было принято решение использовать Adapter Delegates. Выбор категории сопровождается понятным ui-откликом (цвет выбранной категории меняется), несмотря на то, что предоставленный тестовый api выдавал только 1 категорию. При изменении адреса запускается экран с Google Map и кнопкой "Find me", по нажатию по которой сначала запускается запрос на предоставление разрешения, а затем, если пользователь разрешил, камера переносится к его местоположению. Также на карте заранее рассыпаны 10 пинов, имитирующие филиалы магазинов.

Экран детальной информации состоит из viewpager'а с фото товара и его детальной информацией .Он всегда одинаков, так как тестовое api рассчитано на детальную информацию 1 товара.

Экран корзины состоит из recyclerview с добавленными товарами, а также полями общей стоимости товаров корзины и типа доставки

Использовалось кеширование данных: при первом заходе в приложение все данные берутся с сервера, и записываются в базу данных, откуда они достаются при последующих запусках приложения.

Проект зарегистрирован в Firebase и имеет функционал отправки push-уведомлений, по нажатию на которые открывается экран корзины.

Добавлены deeplink'и на каждый экран: mysite.com/home, mysite.com/details, mysite.com/cart
