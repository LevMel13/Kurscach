//import com.didisoft.pgp.PGPException;
//import com.didisoft.pgp.PGPLib;
//
//import java.io.IOException;
//
//public class EncryptMessage {
//    public String Encrypt(String s) throws PGPException, IOException {
//        PGPLib ecryptor = new PGPLib();
//        String key = "mQINBFm/twMBEACvvqLzEsenLHO56DZsS/pI7DmzPXzCxCjzOmvOy8AT4ArKDewn\n" +
//                "PBO87RRWQwwtfHAOI5p0v7mK8fADKOZYFRuI6i7HfrZCQo3ZY8E6b6wJnGeW4dDX\n" +
//                "bWQLtdKhSqh4TazyqGoQUGEPURpfZCiVgeWCB+OlnjdqVgUa7tOfd/hsbNet2IGi\n" +
//                "QVcsMAhDLlKlGqMfRxETf1FZAyDFCvS9PdeEFeTKIBxYTJ5bBoQfUated5YvULDI\n" +
//                "19q11e50JnhsBY1pVZ7bID2TIp4tA2+1LNewDGL83vaaY+Ya6mpY5xpmZGmws9+X\n" +
//                "lZCnfA+tuMgwgsdPU1lZXxebmtJ6Pk1ntgNqYoDusU4XA3Nf1Qna8fn9vI+mrBAX\n" +
//                "uEqVtMRYeOyqGDOv5ULYgvGpaheXk9sD0PgXn+qHk2znFdSdLcg0W49T5Pf5EYgr\n" +
//                "FvDPJ+ejBEqclHhGgKnj9sXrTwiED2CfFjMqvc6K4qk4fijOr8TyhFtfOIk5xj9y\n" +
//                "qgsQZr4JW3WAQC5DER9c2TpyaPzI7mSxcNQsFx0wk1HPhmEc91YWlExQ1xVQ70NB\n" +
//                "sC8BXJgexwylW5ejd5pUGA/j/JeIEdzIbNMo+J6CIjEk2LA43t/ynpMdllzpld0O\n" +
//                "SCoU/A/V2+h7geBYrtHYhIwU4Q7dVvzfOjxgvTN6LZ50vy4lubARirc/ywARAQAB\n" +
//                "tBVOZXh1cyA8cG9zdEBuZXh1cy51YT6JAjkEEwEIACMFAlm/twMCGwMHCwkIBwMC\n" +
//                "AQYVCAIJCgsEFgIDAQIeAQIXgAAKCRCtEqeBmkstY6RrD/4yuUHwksU2YICnn8gg\n" +
//                "xxkQqJS3itYuwO4AMnOI/8OrvCY4+p8g23m8pghvguyLQLi2FUkItxGbzSGsgUMH\n" +
//                "J8JntXzzVuaX2IGp5vG6tYMB8juDhoKodIDrRgcxqVXB8mtiADJgHnH82r5Kozdp\n" +
//                "lFOH9fpFnpE7rU8VwX96cQVIfqyAqV3yGlxaVHPL+q8qCGpgzSOagvXp98pP4uEM\n" +
//                "dbFb/G+bg3KCFwGkWt8joAJlAIW3ksvoldN9HzcFt7WcZBW0/lMzDAhxfDD9lA1+\n" +
//                "t7e+x8xXb//Y54c2TAldfYgiv0yfirDx7cILMnrytIhAXGcqKYOhOJopaC4KAvIE\n" +
//                "ZT1jJ/bnuPmAlyf03CwiU2NlCAHYsa3cXPdou9i69a1Wq5nGA9vPDZqeFeoCdg4n\n" +
//                "iBsn25KOcfKaCV9JiNaSHGYRaiYcnQEhSXyBBzVMV/dUYQRKrl4G8z/VRbFzEYT4\n" +
//                "MY4+TMUI5LHuTsaMUZen3rnCjAQqpp7Npfl4tZ4s8m7RwLPyC8W8N1ql3uP9krWu\n" +
//                "kpna6R/1KF0zhzg6QhU9drXuJ2oxD2ygHVhGWyfggnpmBrsGQ+yzFQLa/raOGQSb\n" +
//                "uJqNULY41xO+8lv/c6hPCsaKVZFQwcP8HoV6bxbpZ31PFcikVCbRBP/XblHGjHJP\n" +
//                "/CAa7Dy8Cdj+wkbZC/iWMoyRdrkCDQRZv7cDARAAv1mpEcpaQ2ePfkbdrO7uto7W\n" +
//                "KzF7OpO+r+YFFBl5iUkr1mjrKDdn7Y9A57/hPoaTBEyJdjSG6TPBfy6UlsHeEVCr\n" +
//                "f1YYI/hWyhOXTbEH9zpZ6YjD9iJX0e39l8Na1FErjF9KIrDmWU4QyaITCnWJPmMs\n" +
//                "G8K7te6r2t2nk8786gjwEW5AewEfNejUGfP6Ozyn7/8RuZMfMMNdLTkrPS0zvmDv\n" +
//                "0BYBCJIPX6UYf+G7S2xEDTEO3NbkGC7Z3KaIE6VGR45coKkLR9ODa7HxPaaxOT8Q\n" +
//                "cJeWFUDfXpJjBxVEVO44o6gzmnIjxDmOx+uGoFYOILx3puNHfC/AmN5d0/oMWlPW\n" +
//                "B8m9IUAtLjwhRNoqSWuHha8lOt96y9Ue0D2K83pzxfHA80zq4d/s63/jg71WUV+d\n" +
//                "QixV28hTSPRmyZaCCS5GA5XU/fw7+gFc3q1cBkt573zr5RhQXTmosj+8+HJoAicu\n" +
//                "/f85LIV3UMoHDKkK8p1NwnH0EVq+sgouQ8eMO4yShPLD+RdebrbH1JQDdQMb4Aom\n" +
//                "XGP1EGzJkGmEhwjz1Oj2AWmjrnhkyNFGzYc1Hwmqw79z+Fvgzb5D9CnYh99eA48V\n" +
//                "85IL9jHNe3tNck7est4GIxvqn2algOoBmFYh/pEH0Qemhce5s+rmDcpAaQ+6u0od\n" +
//                "DswArjLUu0YQ/mFutakAEQEAAYkCHwQYAQgACQUCWb+3AwIbDAAKCRCtEqeBmkst\n" +
//                "Y331D/0aVbvjxr833jfIaKIpATtUsEP7s+t6usexdsh0bLNdhFINbJj79PKMOosS\n" +
//                "06J3GRR8lbnuzh0TfFFsrf3rdmOLoElQaXCoP6NM/Gju0mrhgbeSj31c5C7ZOM1P\n" +
//                "ZqNdRs/pArMyIda6NhTmj+u6jDYloNY3ksluOnrqLKC8eTVceVjdTms/1dW0dS+1\n" +
//                "8r3jHRYW5sclYrlaVJGDPvW5RuNlvTHf7HjSAlYLCLpI1+qSgZwwy1A+yemQU/Xk\n" +
//                "w+ZOkoKrHNZzH+zK7c/pD/F/9wE0Vln5S+YBmJE4GLtSEW4b/NdOQbcMJQnxD8sA\n" +
//                "1cKVdP2ygsEivsyw/5nx/tsF8/9PqxtjeMJzq4UhZ6lnkHNbSv18y+BJv7VvSQHn\n" +
//                "puttGNGEC2W7d39lHNmxL0GnCz9XC9SFQb1wqtNKCNu7K82nujKNeZkOqua2STFd\n" +
//                "Ni/e2S/xiQanJOsbzlnecco1rx+ikHdmgjleim8Sx1KbRvdMnlgMcDflmfP18S1x\n" +
//                "Ik3y2K5OWyUmTWf3TVTwt/rp+J6r179JJ3KEv/q8UQ22ddMskHmasnG7DPK0uvfI\n" +
//                "SHMGW0+8G4MMo8aNCFaHDfL7tysMkFYQdZ18Kq3vDccIF6yr0OqpnPACxEKYntFE\n" +
//                "oC14MviYKTdWc4eSKIrTn5eKL1T+qHqmpnybS+DUfmpbYc4Lvg==\n" +
//                "=7C99";
//        s = ecryptor.encryptString(s, key).toString();
//        return s;
//    }
//}
