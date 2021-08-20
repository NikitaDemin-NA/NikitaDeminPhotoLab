$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/features/FirstStep.feature");
formatter.feature({
  "name": "Тестовый feature-файл",
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
  "name": "извлечь значения id из JSON файла",
  "keyword": "Дано "
});
formatter.match({
  "location": "steps.JSONSteps.addJSON()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пропарсить и отсортировать CSV",
  "keyword": "Тогда "
});
formatter.match({
  "location": "steps.CSVSteps.Test()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "testTest",
  "keyword": "И "
});
formatter.match({
  "location": "steps.JSONSteps.testTest()"
});
formatter.result({
  "status": "passed"
});
});