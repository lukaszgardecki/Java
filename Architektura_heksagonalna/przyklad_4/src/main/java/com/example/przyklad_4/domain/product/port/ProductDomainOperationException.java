package com.example.przyklad_4.domain.product.port;

class ProductDomainOperationException extends DomainOperationException {
    private final ProductDomainOperationErrorCode errorCode;
    public ProductDomainOperationException(
            ProductDomainOperationErrorCode errorCode,
            String message) {
        super(message);
        this.errorCode = errorCode;
    }
    @Override
    public String getErrorCode() {
        return errorCode.toString();
    }

    public enum ProductDomainOperationErrorCode {
        QUANTITY_UNIT_MUST_BE_PROVIDED,
        QUANTITY_MUST_BE_PROVIDED,
        QUANTITY_UNIT_INVALID,
        NEGATIVE_QUANTITY_PROVIDED
    }
}
