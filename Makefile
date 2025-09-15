PROJECT_NAME = java-project-61

# run-dist зависит от install, поэтому сначала соберет, потом запустит
run-dist: install
	./build/install/$(PROJECT_NAME)/bin/$(PROJECT_NAME)

install:
	./gradlew clean installDist

run:
	./gradlew run --console=plain

clean:
	./gradlew clean

.PHONY: install run-dist run clean



#.PHONY: run-dist

#run-dist:
#	./build/install/app/bin/app
