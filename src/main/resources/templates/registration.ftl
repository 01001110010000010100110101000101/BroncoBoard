<html>
    <head>
        <title>BroncoBoard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
        <link href="/css/bootstrap.min.css" rel="stylesheet"></link>
        <script src="//code.jquery.com/jquery-latest.min.js"></script>
	</head>

	<body>
        <div class="container">
            <form class="form-horizontal" action='/registration' method="POST">
                <fieldset>
                    <div id="legend">
                        <legend class="">Register</legend>
                    </div>
                    <div class="control-group">
                        <!-- E-mail -->
                        <label class="control-label" for="id">E-mail</label>
                        <div class="controls">
                            <input type="email" id="id" name="id" placeholder="" class="input-xlarge" required></input>
                            <p class="help-block">Please provide your E-mail</p>
                        </div>
                    </div>
             
                    <div class="control-group">
                        <!-- Password-->
                        <label class="control-label" for="pw">Password</label>
                        <div class="controls">
                            <input type="password" id="pw" name="pw" placeholder="" class="input-xlarge" required></input>
                            <p class="help-block">Password should be at least 4 characters</p>
                        </div>
                    </div>
             
                    <div class="control-group">
                        <!-- Password -->
                        <label class="control-label"    for="pw_confirm">Password (Confirm)</label>
                        <div class="controls">
                            <input type="password" id="pw_confirm" name="pw_confirm" placeholder="" class="input-xlarge" required></input>
                            <p class="help-block">Please confirm password</p>
                        </div>
                    </div>
             
                    <div class="control-group">
                        <!-- Button -->
                        <div class="controls">
                            <button class="btn btn-success" type="submit">Register</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
	</body>
</html>
