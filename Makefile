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

update-stock:
ifneq (,$(wildcard tmp/data/stock.csv))
	rm -f tmp/data/stock-OLD.csv
	cp -p tmp/data/stock.csv     tmp/data/stock-OLD.csv
endif
	ant update-stock

update-stock-info-price:
ifneq (,$(wildcard tmp/data/price))
	rm -rf tmp/data/price-OLD
	cp -rp tmp/data/price      tmp/data/price-OLD
endif
ifneq (,$(wildcard tmp/data/stock-info.csv))
	rm -f tmp/data/stock-info-OLD.csv
	cp -p tmp/data/stock-info.csv  tmp/data/stock-info-OLD.csv
endif
	ant update-stock-info-price

update-dividend-all:
ifneq (,$(wildcard tmp/data/dividend-all.csv))
	rm -f tmp/data/dividend-all-OLD.csv
	cp -p tmp/data/dividend-all.csv     tmp/data/dividend-all-OLD.csv
endif
	ant update-dividend-all

update-dividend:
ifneq (,$(wildcard tmp/data/dividend))
	rm -rf tmp/data/dividend-OLD
	mv     tmp/data/dividend      tmp/data/dividend-OLD
	mkdir  tmp/data/dividend
endif
	ant update-dividend

update-stats:
ifneq (,$(wildcard tmp/data/stats.csv))
	rm -rf tmp/data/stats-OLD.csv
	mv     tmp/data/stats.csv      tmp/data/stats-OLD.csv
endif
	ant update-stats
	cp tmp/data/stats.csv ~/Dropbox/Trade/stats-jp.csv

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
	
	