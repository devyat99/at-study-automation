#language: ru

  Функция: Вход Администратором. Проверка текста элемента "Моя учетная запись"

    Предыстория:
      Пусть В системе есть пользователь "ПОЛЬЗОВАТЕЛЬ" с правами администратора
      И открыт браузер на странице "/login"

    Сценарий: Вход Администратором. Проверка текста элемента "Моя учетная запись"
      Если Авторизоватся как пользователь "ПОЛЬЗОВАТЕЛЬ"
      Тогда Текст элемента Моя учетная запись - "Моя учётная запись"
