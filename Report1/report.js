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
  "name": "извлечь JSON значения",
  "keyword": "Дано "
});
formatter.match({
  "location": "steps.JSONSteps.addJSON()"
});
formatter.result({
  "status": "passed"
});
});