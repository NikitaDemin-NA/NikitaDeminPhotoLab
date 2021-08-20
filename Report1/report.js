$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/FirstStep.feature");
formatter.feature({
  "name": "Проверить что содержимое групп сортировано по весу элементов от большего к меньшему",
  "description": "",
  "keyword": "Функционал",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.scenario({
  "name": "Тест",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@Test"
    }
  ]
});
formatter.step({
  "name": "пропарсить и отсортировать CSV",
  "keyword": "Дано "
});
formatter.match({
  "location": "steps.CustomSteps.CSVFile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "извлечь значения из JSON файла и проверить сортировку",
  "keyword": "Тогда "
});
formatter.match({
  "location": "steps.CustomSteps.addJSON()"
});
formatter.result({
  "status": "passed"
});
});