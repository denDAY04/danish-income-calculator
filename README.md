# Danish Income Calculator (`daic`)
A very basic program for calculating annual income based on hourly wage and Danish rules. 

## Run
As a groovy application it's meant to be run by first installing the distributable. 

> ./gradlew app:clean app:installDist

After which the app can be found in

> cd app/build/install/daic/bin

The app requires three arguments in order: 

1. The year to calculate wages on - this is used to count the number of workdays. 
2. Your hourly wage.
3. The number of hours you work per day; can be a decimal.

An example execution may then be

> ./daic 2021 275 7.5

for calculating the annual income in 2021 when working 7.5 hours per day at a wage of 275 kr. per hour. 