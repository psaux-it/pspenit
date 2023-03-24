import svelte from 'rollup-plugin-svelte';
import commonjs from '@rollup/plugin-commonjs';
import { nodeResolve } from '@rollup/plugin-node-resolve';
import livereload from 'rollup-plugin-livereload';
import terser from '@rollup/plugin-terser';
import typescript from '@rollup/plugin-typescript';
import css from 'rollup-plugin-css-only';
import sveltePreprocess from 'svelte-preprocess'
import copy from 'rollup-plugin-copy'
import autoPreprocess from 'svelte-preprocess';
import json from '@rollup/plugin-json';
import replace from '@rollup/plugin-replace';


const production = !process.env.ROLLUP_WATCH;

function serve() {
	let server;

	function toExit() {
		if (server) server.kill(0);
	}

	return {
		writeBundle() {
			if (server) return;
			server = require('child_process').spawn('npm', ['run', 'start', '--', '--dev'], {
				stdio: ['ignore', 'inherit', 'inherit'],
				shell: true
			});

			process.on('SIGTERM', toExit);
			process.on('exit', toExit);
		}
	};
}

export default {
	input: 'src/main.ts',
	output: {
		format: 'iife',
		name: 'app',
		file: 'public/build/bundle.js'
	},
	plugins: [
		json(),
		copy({
			targets: [{
				src: 'node_modules/bootstrap/dist/**/*',
				dest: 'public/vendor/bootstrap'
			},
			{
				src: 'node_modules/bootstrap-icons/font/*.css',
				dest: 'public/vendor/bootstrap-icons/font'
			},
			{
				src: 'node_modules/bootstrap-icons/font/fonts/*',
				dest: 'public/vendor/bootstrap-icons/font/fonts'
			},
			{
				src: 'node_modules/bootstrap-icons/icons/*.svg',
				dest: 'public/vendor/bootstrap-icons/icons'
			}]
		}),
		replace({
			preventAssignment: true,
			__URL__: production ? "/" : "http://localhost:8080/",
		}),
		svelte({
			preprocess: autoPreprocess(),
			preprocess: sveltePreprocess({ postcss: true }),
			preprocess: sveltePreprocess(),
			compilerOptions: {
				// enable run-time checks when not in production
				dev: !production
			}
		}),
		// we'll extract any component CSS out into
		// a separate file - better for performance
		css({ output: 'bundle.css' }),

		// If you have external dependencies installed from
		// npm, you'll most likely need these plugins. In
		// some cases you'll need additional configuration -
		// consult the documentation for details:
		// https://github.com/rollup/plugins/tree/master/packages/commonjs
		nodeResolve({
			browser: true,
			dedupe: ['svelte']
		}),
		commonjs(),
		typescript({
			sourceMap: !production,
			inlineSources: !production,
			rootDir: './src'
		}),

		// In dev mode, call `npm run start` once
		// the bundle has been generated
		!production && serve(),

		// Watch the `public` directory and refresh the
		// browser on changes when not in production
		!production && livereload('public'),

		// If we're building for production (npm run build
		// instead of npm run dev), minify
		production && terser()
	],
	watch: {
		clearScreen: false
	}
};
