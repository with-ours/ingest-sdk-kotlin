# Changelog

## 0.9.2 (2026-01-31)

Full Changelog: [v0.9.1...v0.9.2](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.9.1...v0.9.2)

### Chores

* **internal:** allow passing args to `./scripts/test` ([78bb51c](https://github.com/with-ours/ingest-sdk-kotlin/commit/78bb51cd066f5bde5ed1fa3c011e4b2c35f2b1c5))

## 0.9.1 (2026-01-26)

Full Changelog: [v0.9.0...v0.9.1](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.9.0...v0.9.1)

### Bug Fixes

* **client:** preserve time zone in lenient date-time parsing ([2713482](https://github.com/with-ours/ingest-sdk-kotlin/commit/27134823d2b2aaf354bdecc3ab984501088b0778))


### Chores

* **internal:** correct cache invalidation for `SKIP_MOCK_TESTS` ([7a397bd](https://github.com/with-ours/ingest-sdk-kotlin/commit/7a397bd5d7837cfdcd6536c40c7e9af0f1af8d7f))

## 0.9.0 (2026-01-22)

Full Changelog: [v0.8.1...v0.9.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.8.1...v0.9.0)

### Features

* **client:** send `X-Stainless-Kotlin-Version` header ([a0307fa](https://github.com/with-ours/ingest-sdk-kotlin/commit/a0307fa9ea9fc4582a04089770bdf9956a7c323e))

## 0.8.1 (2026-01-17)

Full Changelog: [v0.8.0...v0.8.1](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.8.0...v0.8.1)

### Bug Fixes

* **client:** disallow coercion from float to int ([b21607f](https://github.com/with-ours/ingest-sdk-kotlin/commit/b21607fe09d844beffeba1dc87bbfeede113e7d3))
* **client:** fully respect max retries ([ad7a18f](https://github.com/with-ours/ingest-sdk-kotlin/commit/ad7a18fe31c5f3d89d7f8f9f074099feb3acbb09))
* **client:** send retry count header for max retries 0 ([ad7a18f](https://github.com/with-ours/ingest-sdk-kotlin/commit/ad7a18fe31c5f3d89d7f8f9f074099feb3acbb09))
* date time deserialization leniency ([9473bec](https://github.com/with-ours/ingest-sdk-kotlin/commit/9473beca07c52e8ab31e1eb55018603f280a8786))


### Chores

* **ci:** upgrade `actions/setup-java` ([2fb2b06](https://github.com/with-ours/ingest-sdk-kotlin/commit/2fb2b069c2b20c6cfe57783b7222d498b6d8cfef))
* **internal:** codegen related update ([409cfba](https://github.com/with-ours/ingest-sdk-kotlin/commit/409cfbae78271dd4428818609217d8611d57e89c))
* **internal:** codegen related update ([8e116b4](https://github.com/with-ours/ingest-sdk-kotlin/commit/8e116b4000abed0657c8ea8fe37793036a8a4ccf))
* **internal:** depend on packages directly in example ([ad7a18f](https://github.com/with-ours/ingest-sdk-kotlin/commit/ad7a18fe31c5f3d89d7f8f9f074099feb3acbb09))
* **internal:** refactor build files to support future stainless package uploads ([851aa33](https://github.com/with-ours/ingest-sdk-kotlin/commit/851aa33c71ee35de1372fae02800bd0b98685111))
* **internal:** update `actions/checkout` version ([0f8f880](https://github.com/with-ours/ingest-sdk-kotlin/commit/0f8f880494f2adf0d7217ff7eac9d8900d555a11))
* test on Jackson 2.14.0 to avoid encountering FasterXML/jackson-databind[#3240](https://github.com/with-ours/ingest-sdk-kotlin/issues/3240) in tests ([9473bec](https://github.com/with-ours/ingest-sdk-kotlin/commit/9473beca07c52e8ab31e1eb55018603f280a8786))

## 0.8.0 (2026-01-09)

Full Changelog: [v0.7.0...v0.8.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.7.0...v0.8.0)

### Features

* **client:** allow configuring dispatcher executor service ([2203f80](https://github.com/with-ours/ingest-sdk-kotlin/commit/2203f80342bac4295fd592d40e9d400da591f314))

## 0.7.0 (2026-01-06)

Full Changelog: [v0.6.1...v0.7.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.6.1...v0.7.0)

### Features

* **client:** add `HttpRequest#url()` method ([01614d6](https://github.com/with-ours/ingest-sdk-kotlin/commit/01614d692a25abb6c9341442540a3bcdcec4e3f0))

## 0.6.1 (2025-12-19)

Full Changelog: [v0.6.0...v0.6.1](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.6.0...v0.6.1)

### Chores

* **internal:** codegen related update ([eddf21c](https://github.com/with-ours/ingest-sdk-kotlin/commit/eddf21cfc4a36182fcb9c17e28ae4ce8cc130289))
* **internal:** codegen related update ([f35a425](https://github.com/with-ours/ingest-sdk-kotlin/commit/f35a4257334ef589ec4d2d9cc9b218a6ce89c719))
* **internal:** codegen related update ([3e49183](https://github.com/with-ours/ingest-sdk-kotlin/commit/3e49183f8f4ecf2bff26ed2f7c03e52d03fe9608))
* **internal:** codegen related update ([9a66c2a](https://github.com/with-ours/ingest-sdk-kotlin/commit/9a66c2a62fdd2018b19d82f202db2b0731bc6087))

## 0.6.0 (2025-12-17)

Full Changelog: [v0.5.0...v0.6.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.5.0...v0.6.0)

### Features

* **api:** api update ([02bca26](https://github.com/with-ours/ingest-sdk-kotlin/commit/02bca264f84713ae12c07ae3fbcd054474159fc4))

## 0.5.0 (2025-12-11)

Full Changelog: [v0.4.0...v0.5.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.4.0...v0.5.0)

### Features

* **api:** api update ([13be9c1](https://github.com/with-ours/ingest-sdk-kotlin/commit/13be9c1f03fa4fab0b6ca6ae1db02c46b74cec03))

## 0.4.0 (2025-12-11)

Full Changelog: [v0.3.1...v0.4.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.3.1...v0.4.0)

### Features

* **api:** api update ([ad39239](https://github.com/with-ours/ingest-sdk-kotlin/commit/ad39239dd5cce563d70fdd4f20627df34c97ab83))

## 0.3.1 (2025-12-03)

Full Changelog: [v0.3.0...v0.3.1](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.3.0...v0.3.1)

### Documentation

* remove `$` for better copy-pasteabality ([aa74d5f](https://github.com/with-ours/ingest-sdk-kotlin/commit/aa74d5fea764d2cb26188f541d7684bb976cd1cc))

## 0.3.0 (2025-11-19)

Full Changelog: [v0.2.0...v0.3.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.2.0...v0.3.0)

### Features

* **api:** api update ([e58e606](https://github.com/with-ours/ingest-sdk-kotlin/commit/e58e60652fba49ef6883d7b908f76416f2fcec06))
* **api:** api update ([f06413e](https://github.com/with-ours/ingest-sdk-kotlin/commit/f06413e0b73763aa5cc9b1aadf34832f6fcfb5db))

## 0.2.0 (2025-11-19)

Full Changelog: [v0.1.0...v0.2.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.1.0...v0.2.0)

### Features

* **api:** manual updates ([ef35598](https://github.com/with-ours/ingest-sdk-kotlin/commit/ef355986ce0df949ec1d08de43fe2ea7b4e1cb50))


### Bug Fixes

* **client:** multi-value header serialization ([70c72ed](https://github.com/with-ours/ingest-sdk-kotlin/commit/70c72ed3867943de40404e3188a9b4aea503ac85))

## 0.1.0 (2025-11-05)

Full Changelog: [v0.0.1...v0.1.0](https://github.com/with-ours/ingest-sdk-kotlin/compare/v0.0.1...v0.1.0)

### Features

* **api:** manual updates ([021ec33](https://github.com/with-ours/ingest-sdk-kotlin/commit/021ec330e0816b8b7605676d35aedb8c15ff3378))
* **api:** manual updates ([e983c0a](https://github.com/with-ours/ingest-sdk-kotlin/commit/e983c0ae3d76b81c252c957f2f33d90a33378713))


### Chores

* configure new SDK language ([5e753e9](https://github.com/with-ours/ingest-sdk-kotlin/commit/5e753e9e8dfb3892011908f2ae0df8893a38ac9c))
* update SDK settings ([72b2b29](https://github.com/with-ours/ingest-sdk-kotlin/commit/72b2b29242c683f825f083cfdb10f43602317a81))
