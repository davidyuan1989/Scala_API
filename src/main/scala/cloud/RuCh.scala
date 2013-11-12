package cloud

import org.scalatra._
import scalate.ScalateSupport

class RuCh extends ApiStack {
  
  //heartbeat
  //GET /q1
  get("/q1") {
    Query.heartbeat()
  }
  
  //search for tweets which are created at a specific second
  //GET /q2?time=2013-10-02+00:00:00
  get("/q2") {
    Query.search_tweets_by_time({params("time")})
  }
  
  //find the total number of tweets sent by a range of userids
  //GET /q3?=userid_min=133710000&userid_max=137713771
  get("/q3") {
    Query.find_tweets_by_range({params("userid_min")}, {params("userid_max")})
  }
  
  //find the sets of userids who have retweeted any tweet posted by a given userid
  //GET /q4?userid=133710000
  get("/q4") {
    Query.find_retweets_by_userid({params("userid")})
  }
   
}
