#
#
#
SHELL := /bin/bash

all:
	@echo all

clean:
	echo rm -rf tmp/*

#
# misc-lib relate targets
#

# to make project independent from misc-lib, copy files from misc-lib
copy-misc-lib-files:
	cp ../misc-lib/tmp/build/jar/misc-lib.jar data/jar
	cp ../misc-lib/data/jar/*                 data/jar
	cp ../misc-lib/data/market/*              data/market

build-misc-lib:
	pushd ../misc-lib/; ant build ; popd; make copy-misc-lib-files

update-listed-issue:
	mv tmp/data/listed-issue.csv tmp/data/listed-issue.csv-OLD
	ant update-listed-issue

clear-download-page:
	rm -rf tmp/download/page-OLD
	cp -r  tmp/download/page tmp/download/page-OLD

update-stock-price:
	rm -rf tmp/data/price-OLD
	cp -r  tmp/data/price      tmp/data/price-OLD
	cp     tmp/data/stock.csv  tmp/data/stock.csv-OLD
	ant update-stock-price


