package org.example.apiTest;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.listeners.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseAPITest {

    protected String cookie = "hg-client-security=2hSRfI2bcwePE3MxyumTwshpmqo; xoxo7745=eyJpdiI6Ik1jeDc2bEFIWDhiN0gxd01sYmlDc3c9PSIsInZhbHVlIjoiSTcrT2Job0tTdHU5Y1lBSGcrR29LOEQvWDY1cFA3elZPU1R6TWVzVFd1TWFEOCtJbVVXdGdFOElvd05aZ01RWmI3bkRnMHU3djNFUU9XUkRTQVBKNURBWTlIKzhUUjBycE84QXNFaWlqSEN1VjdyS0xxQlpLRkpWKzZYQmdGeUkiLCJtYWMiOiIxNzZiOGVlYWE3OTJjYmI3MGY5MmU2MTA0YTU3YjgzOTkyY2I0MjZiM2UyOGM1NDZjOWVhMmUxMDE1MGJkMDExIiwidGFnIjoiIn0%3D; _gcl_au=1.1.763013517.1717585606; _ym_uid=171758560767486609; _ym_d=1717585607; tmr_lvid=493a5931b899db4d4bb5d7cab071fc19; tmr_lvidTS=1717585608682; _fbp=fb.1.1717585612785.799266909240527860; supportOnlineTalkID=QUn0AgxQnfJc3OHudk9BpkrFsD9UWgtE; locality_id=18091; cookies_accepted=1; stat_cookies_accepted=1; visual_cookies_accepted=1; _7745sitemode=desktop; _ym_isad=2; _gid=GA1.2.677673224.1720964090; domain_sid=qurJsdMHX7u9ghcH3hf-S%3A1720964099919; _ym_visorc=w; previousUrl=https%3A%2F%2F7745.by%2F; _ga=GA1.2.516993976.1717585609; XSRF-TOKEN=eyJpdiI6Ik5qdS9RTTFrcDArU0N5WCttU1Z4amc9PSIsInZhbHVlIjoiR2VkNk41L211SDczNFhuNUwxblJ2Mk40WCt0bE1ac2JDdy9laldMZUxUaXBRWC96SW9jYm9oMXZNbGNYM3pJeTZZYTZVWC9JNCtQVVlma25kRUVQUW53V0taS3JvNFhDS0NzalA1dnZtKzJHKzJzNTQxS1JxM2JKMUMyZy9PMk8iLCJtYWMiOiI3YWNmNzVkZTNjNmJiMDk5MTFmZTVmMWJlYjg1YTgxMTgxZmNiNzEwYjQ1ODJlM2Q5OWZkNWM2ZWFiNDFiMzljIiwidGFnIjoiIn0%3D; bolsoi_magazin_7745_session=eyJpdiI6IkdsUWlKZk5XUWhsb21SY1o3VU1RSEE9PSIsInZhbHVlIjoiQ2FxWGpxYmtQL0tWeEo1bmVzSFM4bDVOSHRQVEtoMFNCRW01Vnczci9YaVFoam5rWGFFa1pINjNHWWI4RjQwdlRlRDFoMGg2U1BUYnFoOUhPWk1KQnFBVnlkOTFRNStmK3FPbDBwWlJiN0MzbnpCN0tsWkRaT1lIbjlvZGx2U2IiLCJtYWMiOiIyNTI0NWIzOGRkYWJkNzAxNGNhZTU5ZmZkZjkxMmM1MDU4ZDZhYTcxMTg3Y2IxYTI1ZjQzYWRiNTU0NGViMjg4IiwidGFnIjoiIn0%3D; tmr_detect=0%7C1720976087164; _ga_WF8S0VLP17=GS1.1.1720975848.33.1.1720976137.58.0.0";
    protected String token = "E4yTB5gY3QX8V9I3bHj2CktZkONkxjoEB3cwYNcw" ;

    @BeforeMethod
    public void url() {
        RestAssured.baseURI = "https://7745.by";
    }
}
