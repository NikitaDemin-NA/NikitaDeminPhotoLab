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
formatter.before({
  "error_message": "java.lang.NullPointerException: Cannot invoke \"com.consol.citrus.dsl.runner.DefaultTestRunner.getTestContext()\" because \"runner\" is null\n\tat steps.OrderedMessageStore.createOrderedMessageStore(OrderedMessageStore.java:14)\n\tat steps.JSONSteps.init(JSONSteps.java:32)\n",
  "status": "failed"
});
formatter.step({
  "name": "добавить JSON в переменную \"bodyJSON\"",
  "keyword": "Тогда "
});
formatter.match({
  "location": "steps.JSONSteps.addJSON(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
});