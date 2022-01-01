Feature: Wordpress Add to Cart from Search

	Scenario: Testing fungsi Add to Cart dari menu Search
		When User mencari barang dari menu Search
		And User memilih barang dari hasil pencarian dan klik Add to Cart
		Then User berhasil menambahkan barang dari hasil pencarian ke Cart