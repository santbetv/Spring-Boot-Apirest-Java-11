package com.sbvdeveloper.apirest.auth;

public class JwtConfig {

	// Codificacion HS256
	public static final String LLAVE_SECRETA = "mi###$&%llavesecreta2021.!springboot";

//	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n"
//			+ "MIIEowIBAAKCAQEAzJeACA3n59ePb9o4axTXHDsI69sd0tdWvOgwYjb5JkXB39wm\n"
//			+ "bO06nL+bHGsW+X3gb1V9DxTwlRmL/P3ipB9w2UHkgaTFDiDcJryJV4JQQqBW3OgB\n"
//			+ "TLKFgSLYYEY4r37lN5NYRfhnOcR+pWD8pn6gQyctWCWoShxZGvf91JIA2QUgbHFI\n"
//			+ "jNox8VMicS3OZFFomR5hbib/1ofywgUmHUi+bOC4Z+OS04d7Ym/B6tEjYIIpoR6F\n"
//			+ "Y+yoF1FjDuxI4jTe6EH5esfI18k4V2CsJ5+lStghzEbvjzfhNlAM+l8CvYe2j3tu\n"
//			+ "RiFrnwZxX8x3uZB9Px0abqL+G0hdi4fn34ChLQIDAQABAoIBAFl5JAfhtPrCXbtn\n"
//			+ "7uZ9nbl949/p2rgbbpZ84LQDIKDpPulcyP04Hjrw3K/n8Ys4zo9CDsgquzAplPwW\n"
//			+ "OCjYiyyoUXuVCIyuODlEmLfJiLoqjvJbED5vkE0yZPhtnVq6nxnX+XHYOaSc11oR\n"
//			+ "+UwC8qmLl5wGE/wdO6a8r6hoFbDScW4pA+rCtQs/KKWvObSU+zVY3ThyKd428qbZ\n"
//			+ "HDaQmI2Cpp2ga0kW+759rLRO10qVniPhS1I0qq/8Ju6HlqrlTzz37bxrKTKTCnKS\n"
//			+ "bTdc9471k3YYKSkOdPJ4LyR2+/vIXW5cSOakGxur+hxLJrB/wjiI3dMnUYTg2ogY\n"
//			+ "ZTi7Qq0CgYEA9kpkeqou2O9DK5gaUidfQAw0dyrizW0t9bwUgStl4TfDTXkcSUst\n"
//			+ "pFvcW6gle6j3FCf49sixUDC7f1sHB1KXDcRZxp1v2uZmkLYmHV6RIGkudTQ/y7C7\n"
//			+ "dP6JZvEAIxI5cNbB5jJSN77OLRl4al+RuUMsLNvGkZA+RYKFj//PSScCgYEA1KhG\n"
//			+ "rtJqnD1Xm9daduO300zu5OIHe7sd3kf1YvwmmCmE9NBB7KKiqfx/Kq8lD/w9d59c\n"
//			+ "45S4ciVjSBDEC5AQMuzgIHYrvw1ikwAWcpR7OOE5UuJBlHR5vjttkHXEqKQl6mmG\n"
//			+ "+V8bJ1ZaiCM7b4tLueW1Zuff3+p+C6EM3wpkb4sCgYBu0SpExy4tDfr7MoUlUfHZ\n"
//			+ "r6QrunAyXl2/o9DWDeDZZW3K/iNsFxeCTJLp6s5yxaPmvdWXtNWTb1nuA9c1xEOT\n"
//			+ "PjXm2A/sPp8Hne2oaVSDcNAmjEvoKq0uBxlr6CRXo2uVCgxUt2+nBYNfZ4Z21mmL\n"
//			+ "Il5OENVXyb87J29RS5jJIQKBgDacWDqA8rvYzOzKawLpC8YJlbfVi9JshQkWNaAL\n"
//			+ "3OVqlChCawuX4GoC261ceQoX3rkfhb0z7gHyNALHu3C0uFQ7nHr5ndZcW5oghaM7\n"
//			+ "GkHLJOtyCyFSoAkIPeTBOZWNQedm3jCgCdsaQ/l+Ar9saC//G4yns0hPcbsOyr1k\n"
//			+ "b9JtAoGBAIxT/BS6vmZa7hXh/FlHspgTQATNzkE3qxynDMBBpbUXXPOap0n/a9S6\n"
//			+ "6WDu+MriGPsfa8gK1zm2og/U1fgr8JzI1F0RuIYyxlQLwarVTHolF2H8vqu5pVV6\n"
//			+ "KRlmxdUNyklep6SrurYEqwAAQqc7XtSKicrPZHnY8guxBeBDSzj3\n" + "-----END RSA PRIVATE KEY-----";
//
//	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n"
//			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzJeACA3n59ePb9o4axTX\n"
//			+ "HDsI69sd0tdWvOgwYjb5JkXB39wmbO06nL+bHGsW+X3gb1V9DxTwlRmL/P3ipB9w\n"
//			+ "2UHkgaTFDiDcJryJV4JQQqBW3OgBTLKFgSLYYEY4r37lN5NYRfhnOcR+pWD8pn6g\n"
//			+ "QyctWCWoShxZGvf91JIA2QUgbHFIjNox8VMicS3OZFFomR5hbib/1ofywgUmHUi+\n"
//			+ "bOC4Z+OS04d7Ym/B6tEjYIIpoR6FY+yoF1FjDuxI4jTe6EH5esfI18k4V2CsJ5+l\n"
//			+ "StghzEbvjzfhNlAM+l8CvYe2j3tuRiFrnwZxX8x3uZB9Px0abqL+G0hdi4fn34Ch\n" + "LQIDAQAB\n"
//			+ "-----END PUBLIC KEY-----";

	// Codificacion RS256
	public static final String RSA_PRIVADA_UBU = "-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEowIBAAKCAQEAsCRooQGgHEowYq0+PJIANnDBBXioTxPTQqz/K8QEgqv0zXgI\n"
			+ "qq7WZ5O3ksN391FPGuFB9zKmFwooSjOCRbGnD6DxvScMtpbqtOHufKhB4hr7t52n\n"
			+ "aCIkE3UPrcj4NlhGCohZRbBJPYzHKEOEZERy4ubH/Fph8AhGDGZAQXeGEne4dcDQ\n"
			+ "NhzoyfmhgduCwUWylofHnGihCO9TQ0rkGs9hcKLD0YdPRMVobH/+YsPZqH/ZBqWH\n"
			+ "sdy6nXpmMI3chANPlObpfSE40R1sHoOijJyzOY0BL75A2IjMpvCBa65xq10FnEFe\n"
			+ "u55Bt/Xefn8VcCZUqBH2nyX58GbWJ6aZN9+HOQIDAQABAoIBAArTcgrTSr/yX17x\n"
			+ "Pu4CGzk9XN+1NsMFeOqUL2rFNXHCl905D29OJ6deEN5YXTs6KB6C0ccbudGYsjk9\n"
			+ "STh3Xsk7HyB9Ee72/532dO38eXAoMGhsrCleT9FSVJBd1cOhUUy8bKA34YiC6oqy\n"
			+ "+6QeAOGpRYlhFLvoBkYk0rYzXm4sC3MwA65KUog49LC7sHe6Mz3LnPL5m4byxuZM\n"
			+ "SiDRxG5N8ShdhPk40fmpN7++I34F3UMtsQNhRJ8uVIBTiw4965nB78/mIMKu4HIr\n"
			+ "JjSZ6KJaDoj5EfyPVAqTEcSDnTxwDuoIg92c5SivsjrQzwuuuXJsGlneHDvqPzqF\n"
			+ "Fcl8TAECgYEA143VGm5w1L965MMObT5K/AliihtxbYagbbVwY22GfcYW0PlzlOmC\n"
			+ "hiT5zDzKj45G8E8WkPH6b2MY5ljPI1ZWEKuRT/OgEkT6RztmVnLNvJk4ioySKQCJ\n"
			+ "REj15DhZKR/60UvR4hNjI4rOHKLvybsqj44tHqZLG/JH3uRinRNY31kCgYEA0TFs\n"
			+ "q/keK8aml4WTzuAb08l38RK5xmnBr9hkQ1bbPafaiXM8UXGExyygzKdAhRJBV//S\n"
			+ "1BuDNx24doWhBNKakg/g0BPubGgPn90J8+b1BJeD8kANJPWojROMg84QyW5R+bXn\n"
			+ "3eNqex7dVuzoaKgo8wrL4YHZt3oF2jued8jfyuECgYARb2p+UdKUksxo9pITKge8\n"
			+ "rTGoRCH/nvUZCqUFldVcFQrBanv73ottOE5wQ7aKuBJq26rSnJAKNHTOJP7UN+aM\n"
			+ "QKRnWChpceTgoCBd+7lCeQ5GvqoP4Pg5asFg7WHg3rJV/ZEDfVf2hwK29EL7CUWf\n"
			+ "CPwDT6Yho45GrCiB1g/JOQKBgFP5hyoxwo7IG6/Pi1oMVJ9bzK4VWkXvxjSUpQrz\n"
			+ "HudNLkjm3VvEOgzKOXJt4VSJ03lD1JoYwT+qypWpZs3MzQe9H/3nQlp6G2uNC6XB\n"
			+ "HLJPMERauewQQS0An/N5EPwLMRUQlJdZ5zCtXyS5zUHV3zpRJy7LNV6VuSu1qxNi\n"
			+ "q5OBAoGBANaXBPv8oof3qiL0VEceUc1Pxt8WhS8tR4ur0cAUl6T162DANQpa6T1l\n"
			+ "H+mE9SXHmHvYFGyMYFRLszLi19KpnFN64oOdsgkSk/nGpN4oMBvvBDmlJZePNUCw\n"
			+ "TrICXwtedKa49eUVnb/Fa5Xv9u8oTFFq00yzzxrp5mtHG/c2zSAz\n" + "-----END RSA PRIVATE KEY-----\n" + "";

	public static final String RSA_PUBLICA_UBU = "AAAAB3NzaC1yc2EAAAADAQABAAABAQCwJGihAaAcSjBirT48kgA2cMEFeKhPE9NCrP8rxASCq/TNeAiqrtZnk7eSw3f3UU8a4UH3MqYXCihKM4JFsacPoPG9Jwy2luq04e58qEHiGvu3nadoIiQTdQ+tyPg2WEYKiFlFsEk9jMcoQ4RkRHLi5sf8WmHwCEYMZkBBd4YSd7h1wNA2HOjJ+aGB24LBRbKWh8ecaKEI71NDSuQaz2FwosPRh09ExWhsf/5iw9mof9kGpYex3LqdemYwjdyEA0+U5ul9ITjRHWweg6KMnLM5jQEvvkDYiMym8IFrrnGrXQWcQV67nkG39d5+fxVwJlSoEfafJfnwZtYnppk334c5";

}
