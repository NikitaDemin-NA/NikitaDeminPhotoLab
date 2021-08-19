#language: ru
#encoding: utf-8

@Test
Функционал: Тестовый feature-файл

  Сценарий: Тест
    #шаг1
    Тогда добавить JSON в переменную "bodyJSON"
    #И извлечь из JSON значение "$.categories..content" в переменную "idJSON"