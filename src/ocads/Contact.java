package ocads;
public class Contact {
    private final int MAX_EMAIL = 3, MAX_SOCIAL = 5;
    private Email[] emails;
    private Social[] socials;
    private ContactInfo contactInfo;
    private String name;
    private int count;

    public Contact(String name) {
        this.name = name;
        this.emails = new Email[MAX_EMAIL];
        this.socials = new Social[MAX_SOCIAL];
        count = 0;
    }

    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return Contact.this.name;
        }
    }

    public static class Email implements ContactInfo {
        private String localPart, domain;

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return this.localPart + "@" + this.domain;
        }
    }

    public static class Social implements ContactInfo {

        private final String title;
        private final String value;

        public Social(String title, String value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }
    public Email addEmail(String localPart, String domain) {
        if((count !=0) && (count !=MAX_EMAIL)){
        emails[count] = new Contact.Email(localPart,domain);
        return emails[count++];
        }
        return null;
        //Implement this method
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if((count !=0) && (count !=MAX_EMAIL)){
            emails[count] = new Contact.Email(firstname,lastname){
                @Override
                public String getTitle() {
                    return "Email";
                }

                @Override
                public String getValue() {
                    return firstname  + "_" + lastname + "@epam.com";
                }

            };
            return emails[count++];
        }
        return null;
        //Implement this method

    }
    public void rename(String newName) {
        //Implement this method
    }
}