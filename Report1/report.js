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
  "name": "пропарсить и отсортировать CSV",
  "keyword": "Тогда "
});
formatter.match({
  "location": "steps.CSVSteps.Test()"
});
formatter.result({
  "status": "passed"
});
});