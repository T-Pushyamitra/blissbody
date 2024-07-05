import React from "react";
// import Link from "next/link";

import styles from "./login.module.scss";

export default function Login() {
  return (
    <div className={styles.container}>
      <div className={styles.leftPanel}>
        <div className={styles.loginBoxLeft}>
          <h1>Login</h1>
          <p>Enter your account details</p>
          <form>
            <div className={styles.inputGroup}>
              <label htmlFor="username">Username</label>
              <input type="text" id="username" />
            </div>
            <div className={styles.inputGroup}>
              <label htmlFor="password">Password</label>
              <input type="password" id="password" />
            </div>
            <a href="#" className={styles.forgotPassword}>
              Forgot Password?
            </a>
            <button type="submit" className={styles.loginButton}>
              Login
            </button>
          </form>
          <p>
            Don’t have an account?{" "}
            <button className={styles.signUpButton}>Sign up</button>
          </p>
        </div>
      </div>
      <div className={styles.rightPanel}>
        <div className={styles.loginBoxRight}>
          <h1>Welcome to Blissbody !</h1>
          <p>Login to access your account</p>
          <img src="assets/bb2.png" alt="Illustration" className={styles.illustration}/>
        </div>
      </div>
    </div>
  );
}
