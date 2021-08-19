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
  "name": "отсортировать CSV2",
  "keyword": "И "
});
formatter.match({
  "location": "steps.CSVSteps.Test2()"
});
formatter.result({
  "error_message": "java.lang.ClassCastException: class [Ljava.lang.String; cannot be cast to class java.lang.Comparable ([Ljava.lang.String; and java.lang.Comparable are in module java.base of loader \u0027bootstrap\u0027)\n\tat java.base/java.util.Collections$ReverseComparator.compare(Collections.java:5286)\n\tat java.base/java.util.TimSort.countRunAndMakeAscending(TimSort.java:355)\n\tat java.base/java.util.TimSort.sort(TimSort.java:220)\n\tat java.base/java.util.Arrays.sort(Arrays.java:1232)\n\tat java.base/java.util.List.sort(List.java:510)\n\tat steps.CSVSteps.Test2(CSVSteps.java:38)\n\tat ✽.отсортировать CSV2(file:///Users/andrei/IdeaProjects/NikitaDeminPhotoLab/src/main/resources/features/FirstStep.feature:11)\n",
  "status": "failed"
});
});