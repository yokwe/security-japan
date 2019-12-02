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
	mv     tmp/download/page tmp/download/page-OLD

update-stock-price:
	rm -rf tmp/data/price-OLD
	cp -r  tmp/data/price      tmp/data/price-OLD
	cp     tmp/data/stock.csv  tmp/data/stock.csv-OLD
	ant update-stock-price

#
# Taxonomy file
#
download-taxonomy-file:
	cd tmp/download; rm -f 61_taxonomy.zip;       wget https://www.jpx.co.jp/equities/listing/xbrl/tvdivq00000088ai-att/61_taxonomy.zip
	cd tmp/download; rm -f tse-cg-2015-04-01.zip; wget https://www.jpx.co.jp/equities/listing/xbrl/tvdivq00000088ai-att/tse-cg-2015-04-01.zip

unpack-taxonomy-file:
	cd tmp/data; rm -rf 61_taxonomy; unzip ../download/61_taxonomy.zip
	cd tmp/data/61_taxonomy; unzip tse-at-2014-01-12.zip; rm -f tse-at-2014-01-12.zip
	cd tmp/data/61_taxonomy; unzip tse-ed-2014-01-12.zip; rm -f tse-ed-2014-01-12.zip
	cd tmp/data/61_taxonomy; unzip tse-re-2014-01-12.zip; rm -f tse-re-2014-01-12.zip
	cd tmp/data/61_taxonomy; 

	cd tmp/data; rm -rf tse-cg-2015-04-01; unzip ../download/tse-cg-2015-04-01.zip
	
	