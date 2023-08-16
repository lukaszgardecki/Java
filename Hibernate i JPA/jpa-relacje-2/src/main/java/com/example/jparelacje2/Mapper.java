package com.example.jparelacje2;

import com.example.jparelacje2.domain.author.Author;
import com.example.jparelacje2.domain.author.AuthorResponseDto;
import com.example.jparelacje2.domain.book.Book;
import com.example.jparelacje2.domain.book.BookResponseDto;
import com.example.jparelacje2.domain.category.Category;
import com.example.jparelacje2.domain.category.CategoryRequestDto;
import com.example.jparelacje2.domain.category.CategoryResponseDto;
import com.example.jparelacje2.domain.city.City;
import com.example.jparelacje2.domain.city.CityRequestDto;
import com.example.jparelacje2.domain.city.CityResponseDto;
import com.example.jparelacje2.domain.zipcode.Zipcode;
import com.example.jparelacje2.domain.zipcode.ZipcodeRequestDto;
import com.example.jparelacje2.domain.zipcode.ZipcodeResponseDto;

import java.util.List;

public class Mapper {

    public static BookResponseDto mapBookToBookResponseDto(Book book) {
        return BookResponseDto.builder()
                .id(book.getId())
                .name(book.getName())
                .categoryName(book.getCategory().getName())
                .authorNames(book.getAuthors().stream().map(Author::getName).toList())
                .build();
    }

    public static List<BookResponseDto> mapBooksToBookResponseDtos(List<Book> books) {
        return books.stream()
                .map(Mapper::mapBookToBookResponseDto)
                .toList();
    }

    public static AuthorResponseDto mapAuthorToAuthorResponseDto(Author author) {
        return AuthorResponseDto.builder()
                .id(author.getId())
                .name(author.getName())
                .zipcodeName(author.getZipcode().getName())
                .bookNames(author.getBooks().stream().map(Book::getName).toList())
                .build();
    }

    public static List<AuthorResponseDto> mapAuthorsToAuthorResponseDtos(List<Author> authors) {
        return authors.stream()
                .map(Mapper::mapAuthorToAuthorResponseDto)
                .toList();
    }

    public static Category mapCategoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto) {
        return Category.builder()
                .name(categoryRequestDto.getName())
                .build();
    }

    public static CategoryResponseDto mapCategoryToCategoryResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .bookNames(category.getBooks().stream().map(Book::getName).toList())
                .build();
    }

    public static List<CategoryResponseDto> mapCategoriesToCategoryResponseDtos(List<Category> categories) {
        return categories.stream()
                .map(Mapper::mapCategoryToCategoryResponseDto)
                .toList();
    }

    public static City mapCityRequestDtoToCity(CityRequestDto cityRequestDto) {
        return City.builder()
                .name(cityRequestDto.getName())
                .build();
    }

    public static CityResponseDto mapCityToCityResponseDto(City city) {
        return CityResponseDto.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

    public static Zipcode mapZipcodeRequestDtoToZipcode(ZipcodeRequestDto zipcodeRequestDto) {
        return Zipcode.builder()
                .name(zipcodeRequestDto.getName())
                .build();
    }

    public static ZipcodeResponseDto mapZipcodeToZipcodeResponseDto(Zipcode zipcode) {
        return ZipcodeResponseDto.builder()
                .id(zipcode.getId())
                .name(zipcode.getName())
                .city(zipcode.getCity())
                .build();
    }
}
