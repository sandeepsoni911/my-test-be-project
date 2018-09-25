
///<reference path =/ftl/lib/angular.js" />
src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.js"
var myApp = angular.module("myModule", []);

 var myController = function ($scope){
	$scope.message = "Sandeep Anglular Controller";
	
	
};

myApp.controller("myController",myController);