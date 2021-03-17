# language: ru
@all
@withdrawal
Функция:Поиск авито

  @success
  Структура сценария: Найдем самые дорогие принтеры на авито
    Пусть открыт ресурс авито
    И в выпадающем списке категорий выбрана Оргтехника
    И в поле поиска введено значение '<Товар>'
    Тогда кликнуть по выпадающему списку региона
    Тогда в поле регион введено значение '<Город>'
    И нажата кнопка показать объявления
    Тогда открылась страница результаты по запросу принтер
    И активирован чекбокс только с фотографией
    И нажать на кнопку показать объявления
    И в выпадающем списке сортировка выбрано значение Дороже
    И в консоль выведено значение название и цены '<количество>' первых товаров

    Примеры:
      | Город       | Товар   | количество |
      | Владивосток | принтер | 2          |
      | Ижевск      | плоттер | 4          |

