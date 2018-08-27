//IIFE Immediately invoked function execution.
(function () {
    //create a module.
    var TFApp = angular.module("TFApp", []);
    //create a controller
    //DI Dependency Injection Design Pattern.

    TFApp.controller("TFController", function ($scope, $http) {
       
        var userDetailsSuccess = function (response) {
            var wip=0;
            var te=0;
            console.log(response.data)
            $scope.userDetails = response.data;
            wip=wip+$scope.userDetails.message['Work in Progress'];
            te=te+$scope.userDetails.message['Total Exposure'];
            if($scope.userDetails.message['status']=="Success")
            {
            drawChart(wip,te);
            $scope.status_customer=true;
            //$scope.nocus=false;
            }
            else
            {
            $scope.status_customer=false;
            drawChart(wip,te);
            //$scope.nocus=true;
            }
        };
        var userDetailsError = function (error) {
            console.log("ERROR :::" + error);
            console.log(error)
        }
            $scope.searchuser=function(read_cin){
            console.log("user login called");
            $http.get("https://bztwi1cu97.execute-api.ap-south-1.amazonaws.com/TF/tf?CIN="+$scope.read_cin)
            .then(userDetailsSuccess,userDetailsError);
        }
        });
})();