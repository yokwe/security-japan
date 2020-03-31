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

save-ods:
	cp ~/Dropbox/Trade/dividend-etf.ods      ~/Dropbox/Trade/SAVE/dividend-etf_$$(date +%Y%m%d).ods
	cp ~/Dropbox/Trade/TEMPLATE_STATS_JP.ods ~/Dropbox/Trade/SAVE/TEMPLATE_STATS_JP_$$(date +%Y%m%d).ods

delete-save:
	find tmp/save -mtime 7 -delete

#
# stock.csv
#
update-stock:
	ant update-stock
	cp -p tmp/data/stock.csv     tmp/save/stock_$$(date +%Y%m%d).csv


#
# update stock-price.csv, stock-info.csv and price
#
update-stock-price:
	ant update-stock-price
	cp -p tmp/data/stock-price.csv tmp/save/stock-price_$$(date +%Y%m%d).csv
	cp -p tmp/data/stock-info.csv  tmp/save/stock-info_$$(date +%Y%m%d).csv
	tar cfz tmp/save/price_$$(date +%Y%m%d).taz tmp/data/price


#
# tdnet.touch
#   "ant download-ufocatch" download file, it will touch tmp/data/tdnet.touch
#
download-ufocatch:
	ant download-ufocatch

download-ufocatch-all:
	ant download-ufocatch-all


#
# release.csv and tmp/data/tdnet/*
#   "ant download-release" download file, it will touch tmp/data/tdnet.touch
#
download-release:
	ant download-release

download-release-all:
	ant download-release-all

#
# reit-report.csv
#
tmp/data/reit-report.csv: tmp/data/tdnet.touch
	ant update-reit-report
	cp -p tmp/data/reit-report.csv  tmp/save/reit-report_$$(date +%Y%m%d).csv

update-reit-report: tmp/data/reit-report.csv


#
# stock-report.csv
#
tmp/data/stock-report.csv: tmp/data/tdnet.touch
	ant update-stock-report
	cp -p tmp/data/stock-report.csv  tmp/save/stock-report_$$(date +%Y%m%d).csv


#
# dividend-etf.csv
#
tmp/data/dividend-etf.csv: ~/Dropbox/Trade/dividend-etf.ods
	ant update-dividend-etf
	cp -p tmp/data/dividend-etf.csv  tmp/save/dividend-etf_$$(date +%Y%m%d).csv

update-dividend-etf: tmp/data/dividend-etf.csv


#
# dividend-reit.csv
#
tmp/data/dividend-reit.csv: tmp/data/reit-report.csv
	ant update-dividend-reit
	cp -p tmp/data/dividend-reit.csv  tmp/save/dividend-reit_$$(date +%Y%m%d).csv

update-dividend-reit: tmp/data/dividend-reit.csv


#
# dividend-stock.csv
#
tmp/data/dividend-stock.csv: tmp/data/stock-info.csv
	ant update-dividend-stock
	cp -p tmp/data/dividend-stock.csv  tmp/save/dividend-stock_$$(date +%Y%m%d).csv

update-dividend-stock: tmp/data/dividend-stock.csv


#
# dividend.touch
#
tmp/data/dividend.touch: tmp/data/dividend-etf.csv tmp/data/dividend-reit.csv tmp/data/dividend-stock.csv
	ant update-dividend
	tar cfz tmp/save/dividend_$$(date +%Y%m%d).taz tmp/data/dividend
	touch tmp/data/dividend.touch

update-dividend: tmp/data/dividend.touch


#
# dividend-annual.csv
#
tmp/data/dividend-annual.csv: tmp/data/dividend-etf.csv tmp/data/dividend-reit.csv tmp/data/dividend-stock.csv
	ant update-dividend-annual
	cp -p tmp/data/dividend-annual.csv  tmp/save/dividend-annual_$$(date +%Y%m%d).csv

update-dividend-annual: tmp/data/dividend-annual.csv


#
# stats-jp.csv
#
#  report-stats-jp depends on dividend-annual.csv and stock-info.csv
#  dividend-annual.csv change frequently, so ignore dependency in this target
#
tmp/data/stats-jp.csv: tmp/data/dividend-annual.csv tmp/data/stock-info.csv
	ant report-stats-jp
	cp -p tmp/data/stats-jp.csv  tmp/save/stats-jp_$$(date +%Y%m%d).csv
	cp -p tmp/data/stats-jp.csv  ~/Dropbox/Trade/stats-jp.csv

report-stats-jp: tmp/data/stats-jp.csv

update-stats-jp:
	ant update-stats-jp
	cp -p tmp/data/stats-jp.csv  tmp/save/stats-jp_$$(date +%Y%m%d).csv
	cp -p tmp/data/stats-jp.csv  ~/Dropbox/Trade/stats-jp.csv

#
# edinet-document.csv
#
update-edinet-document:
	ant update-edinet-document
	cp -p tmp/data/edinet-document.csv  tmp/save/edinet-document_$$(date +%Y%m%d).csv


#
# tmp/disclosure
#   "ant download-edinet-document" download file, it will touch tmp/data/edinet.touch
#
tmp/data/edinet.touch: tmp/data/edinet-document.csv
	ant download-edinet-document

download-edinet-document: tmp/data/edinet.touch


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
	
	
