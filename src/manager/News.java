package manager;


import java.util.Date;
import java.util.List;

import research.Researcher;

 
    
    enum Category {
        RESEARCH, STUDY;

        public static Category get(int ordinal) {
            return Category.values()[ordinal];
        }
    }

    /**
     * The News class represents a news item in the educational institution management system.
     * It includes information such as headline, topic, comments, publication date, and category.
  
     */
    public class News {

        // Unique identifier for the news item
        private int id;

        // The headline of the news
        private String headline;

        // The topic of the news
        private String topic;

        // List of comments associated with the news
        private List<String> comments;

        // The publication date of the news
        private Date publicationDate;

        // The category of the news (e.g., RESEARCH, STUDY)
        private Category category;

        /**
         * Constructs a new News object with the specified ID, headline, topic, comments, publication date, and category.
         *
         * @param id              The unique identifier for the news item.
         * @param headline        The headline of the news.
         * @param topic           The topic of the news.
         * @param comments        The list of comments associated with the news.
         * @param publicationDate The publication date of the news.
         * @param category        The category of the news.
         */
        public News(int id, String headline, String topic, List<String> comments, Date publicationDate, Category category) {
            this.id = id;
            this.headline = headline;
            this.topic = topic;
            this.comments = comments;
            this.publicationDate = publicationDate;
            this.category = category;
        }

        /**
         * Gets the unique identifier for the news item.
         *
         * @return The ID of the news item.
         */
        public int getId() {
            return id;
        }

        /**
         * Views news items based on the provided news list.
         *
         * @param newsList The list of news items to view.
         */
        public static void viewNews(Vector<News> newsList) {
            Stream<News> researchNewsStream = newsList.stream()
                                                      .filter(news -> news.category == Category.RESEARCH);
            Stream<News> otherNewsStream = newsList.stream()
                                                   .filter(news -> news.category != Category.RESEARCH);

            List<News> sortedNews = Stream.concat(researchNewsStream, otherNewsStream)
                                          .collect(Collectors.toList());

            for (News news : sortedNews) {
                System.out.println(news.headline + " - " + news.topic + " [" + news.category + "]");
            }
        }

        /**
         * Adds a comment to the list of comments associated with the news.
         *
         * @param comment The comment to add.
         */
        public void addComment(String comment) {
            comments.add(comment);
        }
    }

