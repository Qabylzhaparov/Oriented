package manager;


import java.util.Date;
import java.util.List;

import research.Researcher;

 
    
//    enum Category {
//        RESEARCH, STUDY;
//
//        public static Category get(int ordinal) {
//            return Category.values()[ordinal];
//        }
//    }

    public class News {
    	private int id;
        private String headline;
        private String topic;
        private List<String> comments;
        private Date publicationDate;
        private Category category;

        public News(int id, String headline, String topic, List<String> comments, Date publicationDate, Category category) {
        	this.id = id;
            this.headline = headline;
            this.topic = topic;
            this.comments = comments;
            this.publicationDate = publicationDate;
            this.category = category;
    }
        
        
        public int getId() {
            return id;
        }
    
//    public static void viewNews(Vector<News> newsList) {
//        
//        Stream<News> researchNewsStream = newsList.stream()
//                                                  .filter(news -> news.category == Category.RESEARCH);
//        Stream<News> otherNewsStream = newsList.stream()
//                                               .filter(news -> news.category != Category.RESEARCH);
//
//        List<News> sortedNews = Stream.concat(researchNewsStream, otherNewsStream)
//                                      .collect(Collectors.toList());
//
//        
//        for (News news : sortedNews) {
//            System.out.println(news.headline + " - " + news.topic + " [" + news.category + "]");
//        }
//    }

    
    
    public void addComment(String comment) {
    	comments.add(comment);
    }
    
   
    
    
    
    
    
                      
    
    
    
    
    
}
