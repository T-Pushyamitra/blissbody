import React, { useState } from "react";

import styles from "./login.module.scss";

export default function Login() {
  const [isSignUp, setIsSignUp] = useState(false);

  function handleSubmit() {
    alert("Yet to handle submissions");
  }

  function handleSignUp() {
    setIsSignUp(true); //New User
  }

  return (
    <div className={styles.container}>
      <div className={styles.leftPanel}>
        <div className={styles.loginBoxLeft}>
          {isSignUp ? (
            <div className={styles.formContainerLogin}>
              <h1>Sign Up</h1>
              <p>Enter your account details</p>
              <form>
                <div className={styles.inputGroup}>
                  <input type="text" id="username" placeholder="Enter your username"/>
                </div>
                <div className={styles.inputGroup}>
                  <input type="text" id="mobile-number" placeholder="Enter your mobile number"/>
                </div>
                <div className={styles.inputGroup}>
                  <input type="password" id="password" placeholder="Enter your password"/>
                </div>
                <button
                  type="submit"
                  className={styles.loginButton}
                  onClick={handleSubmit}
                >
                  Sign Up
                </button>
              </form>
            </div>
          ) : (
            <div className={styles.formContainerLogin}>
              <h1>Login</h1>
              <p>Enter your account details</p>
              <form>
                <div className={styles.inputGroup}>
                  <input type="text" id="username" placeholder="Username" />
                </div>
                <div className={styles.inputGroup}>
                  <input type="password" id="password" placeholder="Password"/>
                </div>
                <a href="#" className={styles.forgotPassword}>
                  Forgot Password?
                </a>
                <button
                  type="submit"
                  className={styles.loginButton}
                  onClick={handleSubmit}
                >
                  Login
                </button>
              </form>
              <p>
                Don’t have an account?{" "}
                <button className={styles.signUpButton} onClick={handleSignUp}>
                  Sign up
                </button>
              </p>
            </div>
          )}
        </div>
      </div>
      <div className={styles.rightPanel}>
        <div className={styles.loginBoxRight}>
          <h1>Welcome to Blissbody !</h1>
          <p>Login to access your account</p>
          <img
            src="assets/bb2.png"
            alt="Illustration"
            className={styles.illustration}
          />
        </div>
      </div>
    </div>
  );
}
