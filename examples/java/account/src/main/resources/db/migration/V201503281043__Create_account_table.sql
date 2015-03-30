CREATE TABLE account (
 iban VARCHAR(18),
 bic VARCHAR(10),
 UNIQUE KEY (bic, iban)
);
