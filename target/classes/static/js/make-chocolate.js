angular.module('MakeChocolateApp', [])

   .controller('MakeChocolateController', function($scope, $http,$timeout) {
                         $scope.usedSmallBars=0;
                         $scope.usedBigBars=0;

              $scope.makeChocolate = function() {
                    console.log("About to add the following game " + JSON.stringify($scope.chocolateRequest));
                    $http.post("/makeChocolate.json", $scope.chocolateRequest)
                        .then(
                            function successCallback(response) {
                                console.log(response.data);
                                console.log("Adding data to scope");
                                $scope.madeChocolates = response.data;
                                $scope.processSolutionBigBars();
                                $scope.processSolutionSmallBars();
                            },
                            function errorCallback(response) {
                                console.log("Unable to get data");
                            });
                };

               $scope.processSolutionBigBars = function() {
                 console.log("processSolution");
                  if ($scope.madeChocolates.bigBarsUsed<0) {
                   $scope.createError();
                  }
                if ($scope.madeChocolates.bigBarsUsed<=0) {
                console.log("Done processing solution!");
                            return;
         }
                    $scope.madeChocolates.bigBarsUsed--;
                    $scope.chocolateRequest.bigBars--;
                    $scope.usedBigBars++;
                    $timeout($scope.processSolutionBigBars, 1000);
               }

               $scope.processSolutionSmallBars = function() {
                   console.log("processSolution");
                    if ($scope.madeChocolates.smallBarsUsed<=0) {
                        console.log("Done processing solution!");
                        return;
                    }
                    $scope.notEnough = "";
                    $scope.madeChocolates.smallBarsUsed--;
                    $scope.chocolateRequest.smallBars--;
                    $scope.usedSmallBars++;
                    $timeout($scope.processSolutionSmallBars, 1000);
                }


                  $scope.createError = function() {
                   $scope.notEnough = " CANNOT MAKE CHOCOLATE:Please Insert More Chocolate Bars";
                            }

                  $scope.makeArray = function(arraySize) {
                        var returnArray = [];
                        for (var i = 0; i < arraySize; i++) {
                            returnArray.push(i);
                        }
                        return returnArray;
                    }
               });