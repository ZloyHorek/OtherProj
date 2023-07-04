package HomeWorkEquals;
import java.time.LocalDate;
import java.util.Objects;

public class Equals_hash {
   public static class Publication {
       private Long id;
       private int version;
       private String title;
       private LocalDate publishingDate; //класс возвращающий дату
       private Author[]authors;

       public Long getId() {
           return id;
       }

       public void setId(Long id) {
           this.id = id;
       }

       public int getVersion() {
           return version;
       }

       public void setVersion(int version) {
           this.version = version;
       }

       public String getTitle() {
           return title;
       }

       public void setTitle(String title) {
           this.title = title;
       }

       public LocalDate getPublishingDate() {
           return publishingDate;
       }

       public void setPublishingDate(LocalDate publishingDate) {
           this.publishingDate = publishingDate;
       }

       public Author[] getAuthors() {
           return authors;
       }

       public void setAuthors(Author[] authors) {
           this.authors = authors;
       }

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;
           Publication that = (Publication) o;
           return version == that.version && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(publishingDate, that.publishingDate) && Objects.equals(authors, that.authors);
       }

       @Override
       public int hashCode() {
           return Objects.hash(id, version, title, publishingDate, authors);
       }

       public Publication(){

       }
   }

    public static class BlogPost{
        private String url;

        public String getUrl() {return url;}
        public void setUrl(String url) {this.url = url;}
    }

    public static class  Book{
        private int numPages;

        public int getNumPages() {return numPages;}
        public void setNumPages(int numPages) {this.numPages = numPages;}
    }

    public static class Author extends Publication{
        private String FirstName;
        private String LastName;
        private Publication[]publications;

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public Publication[] getPublications() {
            return publications;
        }

        public void setPublications(Publication[] publications) {
            this.publications = publications;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Author author = (Author) o;
            return Objects.equals(FirstName, author.FirstName) && Objects.equals(LastName, author.LastName) && Objects.equals(publications, author.publications);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), FirstName, LastName, publications);
        }

        public Author(){

        }
    }

    class EqualsTester{
        public static void main(String[] args){

            BlogPost blogPost;
            Book book;

            Book b1 = new Book();
            b1.numPages = 20;
            Book b2 = new Book();
            b2.numPages = 990;
            Book b3 = new Book();
            b3.numPages = 70;
            Book b4 = new Book();
            b4.numPages = 140;
            Book b5 = new Book();
            b5.numPages = 40;

            BlogPost bp1 = new BlogPost();
            bp1.url = "www.qwerty";
            BlogPost bp2 = new BlogPost();
            bp2.url = "www.qwerty";
            BlogPost bp3 = new BlogPost();
            bp3.url = "www.qwerty";
            BlogPost bp4 = new BlogPost();
            bp4.url = "www.qwerty";
            BlogPost bp5 = new BlogPost();
            bp5.url = "www.qwerty";

            Publication p1 = new Publication();
            p1.id = 1l;
            p1.version =1;
            p1.title="Q";
            p1.publishingDate = LocalDate.now();

            Publication p2 = new Publication();
            p2.id = 2l;
            p2.version =2;
            p2.title="W";
            p2.publishingDate = LocalDate.now();

            Publication p3 = new Publication();
            p3.id = 3l;
            p3.version =3;
            p3.title="E";
            p3.publishingDate = LocalDate.now();

            Publication p4 = new Publication();
            p4.id = 4l;
            p4.version =4;
            p4.title="R";
            p4.publishingDate = LocalDate.now();

            Publication p5 = new Publication();
            p5.id = 5l;
            p5.version =5;
            p5.title="T";
            p5.publishingDate = LocalDate.now();

            Publication p6 = new Publication();
            p6.id = 6l;
            p6.version =6;
            p6.title="Y";
            p6.publishingDate = LocalDate.now();


            Author a1 = new Author();
            a1.FirstName = "Alex";
            a1.LastName = "Pupkin";

            Author a2 = new Author();
            a2.FirstName = "Ax";
            a2.LastName = "Kin";

            Author a3 = new Author();
            a3.FirstName = "Lex";
            a3.LastName = "Pup";

            Author a4 = new Author();
            a4.FirstName = "Lii";
            a4.LastName = "In";

            Author a5 = new Author();
            a5.FirstName = "Rick";
            a5.LastName = "Sanchez";

            Author a6 = new Author();
            a6.FirstName = "Mary";
            a6.LastName = "Grey";

            Author a7 = new Author();
            a6.FirstName = "Ken";
            a6.LastName = "Grey";

            Author a8 = new Author();
            a6.FirstName = "Grey";
            a6.LastName = "Grey";

            Author a9 = new Author();
            a6.FirstName = "Kriss";
            a6.LastName = "Grey";

            Author a10 = new Author();
            a6.FirstName = "Sam";
            a6.LastName = "Grey";

            Author a11 = new Author();
            a6.FirstName = "Kevin";
            a6.LastName = "Grey";

            Author a12 = new Author();
            a6.FirstName = "Bob";
            a6.LastName = "Grey";

            Author a13 = new Author();
            a6.FirstName = "Bon";
            a6.LastName = "Grey";

            Author a14 = new Author();
            a6.FirstName = "Lola";
            a6.LastName = "Grey";

            Author a15 = new Author();
            a6.FirstName = "Michal";
            a6.LastName = "Grey";

            Author a16 = new Author();
            a6.FirstName = "Sauron";
            a6.LastName = "Grey";

            Author a17 = new Author();
            a6.FirstName = "Frodo";
            a6.LastName = "Grey";

            Author a18 = new Author();
            a6.FirstName = "Patrick";
            a6.LastName = "Grey";

            Author a19 = new Author();
            a6.FirstName = "Garry";
            a6.LastName = "Grey";

            Author a20 = new Author();
            a6.FirstName = "Kyle";
            a6.LastName = "Grey";

            Author a21 = new Author();
            a6.FirstName = "Stan";
            a6.LastName = "Grey";

            Author a22 = new Author();
            a6.FirstName = "Kenny";
            a6.LastName = "Grey";

            Author a23 = new Author();
            a6.FirstName = "Wendy";
            a6.LastName = "Grey";

            Author a24 = new Author();
            a6.FirstName = "Kartmen";
            a6.LastName = "Grey";

            Author a25 = new Author();
            a6.FirstName = "Sam";
            a6.LastName = "Grey";

            Author[]authors = {a1,a2,a3,a4,a5,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25};
            Publication[]publications = {p1,p2,p3,p4,p5,p6};
            System.out.println("Java");
            System.out.println(a25.LastName.equals(a24.LastName));

        }
    }
}
