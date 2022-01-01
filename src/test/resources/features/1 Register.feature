Feature: Wordpress Register

	Scenario: Testing fungsi Register
		Given User buka halaman website
		When User klik menu My Account
		And User memasukan username email dan password dan klik Submit
		Then User berhasil membuat akun