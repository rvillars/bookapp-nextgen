'use strict';

var bookapp = angular.module('bookapp');

bookapp.factory('Book', ['$resource', function ($resource) {
    return $resource('rest/books/:bookId', {bookId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);

bookapp.factory('Author', ['$resource', function ($resource) {
    return $resource('rest/authors/:authorId', {authorId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);