> mysql 

Login into MySQL.

select database using
use userservice;


How Flyway Works
To keep track of which migrations we've already applied and when, it adds a special bookkeeping table to our schema. This metadata table also tracks migration checksums, and whether or not the migrations were successful.
The framework performs the following steps to accommodate evolving database schemas:
It checks a database schema to locate its metadata table (SCHEMA_VERSION by default). If the metadata table doesn't exist, it will create one.
It scans an application classpath for available migrations.
It compares migrations against the metadata table. If a version number is lower or equal to a version marked as current, it's ignored.
It marks any remaining migrations as pending migrations. These are sorted based on the version number and are executed in order.
As each migration is applied, the metadata table is updated accordingly.

Flyway supports the following basic commands to manage database migrations:

- Info: Prints current status/version of a database schema. It prints which migrations are pending, which migrations have been applied, the status of applied migrations, and when they were applied.
- Migrate: Migrates a database schema to the current version. It scans the classpath for available migrations and applies pending migrations.
- Baseline: Baselines an existing database, excluding all migrations, including baselineVersion. Baseline helps to start with Flyway in an existing database. Newer migrations can then be applied normally.
- Validate: Validates current database schema against available migrations.
- Repair: Repairs metadata table.
- Clean: Drops all objects in a configured schema. Of course, we should never use clean on any production database.