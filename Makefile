# Build the project
build:
	mvn clean install

# Run all tests
run-tests:
	make build
	./target/surefire-reports/TEST-com_example_householdgrocery_forecasting_ForecastingEngineTest.xml