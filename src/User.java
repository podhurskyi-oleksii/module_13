import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Object street;
    private Object suite;
    private Object city;
    private Object zipcode;
    private Object lat;
    private Object lng;
    private String phone;
    private String website;
    private String nameCompany;
    private String catchPhrase;
    private String bs;

    // геттеры и сеттеры для поля класса
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getStreet() {
        return street;
    }

    public void setStreet(Object street) {
        this.street = street;
    }

    public Object getSuite() {
        return suite;
    }

    public void setSuite(Object suite) {
        this.suite = suite;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getZipcode() {
        return zipcode;
    }

    public void setZipcode(Object zipcode) {
        this.zipcode = zipcode;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (id != user.id) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(email, user.email)) return false;
        return Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    // красивый предпросмотр, как на сайте
    @Override
    public String toString() {
        return "{\n" +
                "    \"id\": " + getId() + ",\n" +
                "    \"name\": \"" + getName() + "\",\n" +
                "    \"username\": \"" + getUsername() + "\",\n" +
                "    \"email\": \"" + getEmail() + "\",\n" +
                "    \"address\": {\n" +
                "        \"street\": \"" + getStreet() + "\",\n" +
                "        \"suite\": \"" + getSuite() + "\",\n" +
                "        \"city\": \"" + getCity() + "\",\n" +
                "        \"zipcode\": \"" + getZipcode() + "\",\n" +
                "        \"geo\": {\n" +
                "            \"lat\": \"" + getLat() + "\",\n" +
                "            \"lng\": \"" + getLng() + "\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"phone\": \"" + getPhone() + "\",\n" +
                "    \"website\": \"" + getWebsite() + "\",\n" +
                "    \"company\": {\n" +
                "        \"name\": \"" + getNameCompany() + "\",\n" +
                "        \"catchPhrase\": \"" + getCatchPhrase() + "\",\n" +
                "        \"bs\": \"" + getBs() + "\"\n" +
                "    }\n" +
                "}";
    }

    public static User defaultUser() { // создаст дефолтный экземпляр Объекта Пользователь (Сергей)
        User result = new User();
        result.setId(8);
        result.setName("User");
        result.setUsername("User");
        result.setEmail("example@mail.com");
        result.setStreet("Random");
        result.setSuite("99");
        result.setCity("City");
        result.setZipcode(7777);
        result.setLat(00.00);
        result.setLng(10.00);
        result.setPhone("+380123456789");
        result.setWebsite("www.google.com");
        result.setNameCompany("Example.company");
        result.setCatchPhrase("Example Phrase");
        result.setBs("Example something");
        return result;
    }

    public static String transformToJson(User user) {
        return "{\"id\":" + user.getId() + ",\"name\":\"" + user.getName() + "\",\"username\":\"" + user.getUsername() +
                "\",\"email\":\"" + user.getEmail() + "\",\"street\":\"" + user.getStreet() +
                "\",\"suite\":\"" + user.getSuite() + "\",\"city\":\"" + user.getCity() + "\",\"zipcode\":" +
                user.getZipcode() + ",\"lat\":" + user.getLat() + ",\"lng\":" + user.getLng() +
                ",\"phone\":\"" + user.getPhone() + "\",\"website\":\"" + user.getWebsite() + "\"," +
                "\"nameCompany\":\"" + user.getNameCompany() + "\",\"catchPhrase\":\"" + user.getCatchPhrase() +
                "\",\"bs\":\"" + user.getBs() + "\"}";
    }


    public static User transformToClass(String data) {
        User result = new User();
        while (data.length() > 1) {
            String stringFragmentToBeChecked = "";
            if (data.contains("\n")) {
                stringFragmentToBeChecked = data.substring(0, data.indexOf('\n'));
            } else {
                stringFragmentToBeChecked = data;
            }
            String fragmentFormatting = stringFragmentToBeChecked.strip();
            fragmentFormatting = fragmentFormatting.replace("{", "");
            fragmentFormatting = fragmentFormatting.replace("}", "");
            fragmentFormatting = fragmentFormatting.replace(",", "");
            fragmentFormatting = fragmentFormatting.replace("\"", "");
            String[] informationParts = fragmentFormatting.split(":");
            if (informationParts.length == 2) {
                if (informationParts[1].length() > 1) {
                    switch (informationParts[0]) {
                        case "id":
                            result.setId(Integer.parseInt(informationParts[1].strip()));
                            break;
                        case "name":
                            if (result.getName() == null) {
                                result.setName(informationParts[1].strip());
                            } else {
                                result.setNameCompany(informationParts[1].strip());
                            }
                            break;
                        case "username":
                            result.setUsername(informationParts[1].strip());
                            break;
                        case "email":
                            result.setEmail(informationParts[1].strip());
                            break;
                        case "street":
                            result.setStreet(informationParts[1].strip());
                            break;
                        case "suite":
                            result.setSuite(informationParts[1].strip());
                            break;
                        case "city":
                            result.setCity(informationParts[1].strip());
                            break;
                        case "zipcode":
                            result.setZipcode(informationParts[1].strip());
                            break;
                        case "lat":
                            result.setLat(informationParts[1].strip());
                            break;
                        case "lng":
                            result.setLng(informationParts[1].strip());
                            break;
                        case "phone":
                            result.setPhone(informationParts[1].strip());
                            break;
                        case "website":
                            result.setWebsite(informationParts[1].strip());
                            break;
                        case "nameCompany":
                            result.setNameCompany(informationParts[1].strip());
                            break;
                        case "catchPhrase":
                            result.setCatchPhrase(informationParts[1].strip());
                            break;
                        case "bs":
                            result.setBs(informationParts[1].strip());
                            break;
                        default:
                            break;
                    }
                }
            }
            if (data.length() > 3) {
                data = data.substring(stringFragmentToBeChecked.length() + 1);
            } else {
                data = data.substring(stringFragmentToBeChecked.length());
            }
        }
        return result;
    }
}
