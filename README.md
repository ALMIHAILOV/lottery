# lottery
  - Запрос на добавление участника /lottery/participant
    Пример тела запроса: 
    {
      "name": "Имя",
      "age": "37",
      "city": "Москва"
    }
  - Запрос для запуска лотереи /lottery/start
  - Запрос списка победителей  /lottery/winners

В качестве DB использована H2 in memory.
